package com.example.COVISHOT.controller;

import com.example.COVISHOT.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody VaccinationCenterRequestDto vaccinationCenterRequestDto){

        VaccinationCenterResponseDto vaccinationCenterResponseDto = vaccinationCenterService.addCenter(vaccinationCenterRequestDto);
        return new ResponseEntity(vaccinationCenterResponseDto, HttpStatus.CREATED);
    }

    //get the list of all the doctors at a particular center{center_id}
    @GetMapping("/get-all-doctors")
    public ResponseEntity getAllDoctorsAtCenter(@RequestParam Integer id){

        List<DoctorResponseDto> doctorResponseDtos = vaccinationCenterService.getAllDoctorsAtCenter(id);
        return new ResponseEntity<>(doctorResponseDtos, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-doctors/gender/{gender}/center/{center_id}/age/{age}")
    public ResponseEntity getAllGenderDoctorsAtCenterAgeAboveX(@PathVariable String gender, @PathVariable Integer age, @PathVariable Integer id){

        List<DoctorResponseDto> doctorResponseDtoList = vaccinationCenterService.getAllGenderDoctorsAtCenterAgeAboveX(gender, age, id);

        return new ResponseEntity(doctorResponseDtoList, HttpStatus.FOUND);
    }


}
