package com.example.COVISHOT.controller;

import com.example.COVISHOT.dto.RequestDTO.DoctorRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.exception.CenterNotPresentException;
import com.example.COVISHOT.model.Doctor;
import com.example.COVISHOT.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){

        try{
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        }
        catch(CenterNotPresentException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //get all doctors who have more than 10 appointments
    @GetMapping("/more-than-10-appointments")
    public ResponseEntity doctorsMoreThan10Appointments(){
        List<String> ans = doctorService.doctorsMoreThan10Appointments();
        return new ResponseEntity(ans, HttpStatus.FOUND);
    }

    @GetMapping("/male-age-greater-than-40")
    public ResponseEntity maleDoctorsAgeGreaterThan40(){
        List<String> ans = doctorService.maleDoctorsAgeGreaterThan40();
        return new ResponseEntity(ans, HttpStatus.FOUND);
    }

    // get the ratio of male to female doctors

    // update the details based on email id of the doctor


    @PutMapping("/update-by-email-id")//Check postman
    public ResponseEntity updateDoctorById(@RequestParam(value = "id") Integer id, @RequestBody DoctorRequestDto doctorRequestDto){

        DoctorResponseDto doctorResponseDto = doctorService.updateDoctorById(id, doctorRequestDto);
        return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get-male-female-ratio")
    public ResponseEntity getDoctorsMaleToFemaleRatio() throws ArithmeticException{

        double ratio = doctorService.getDoctorsMaleToFemaleRatio();
        return new ResponseEntity(ratio, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/id/{id}")//check postman
    public String deleteDoctorById(@PathVariable Integer id){

        return doctorService.deleteDoctorById(id);
    }
}
