package com.example.COVISHOT.controller;

import com.example.COVISHOT.dto.RequestDTO.AppointmentRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.AppointmentResponseDto;
import com.example.COVISHOT.exception.DoctorNotFoundException;
import com.example.COVISHOT.exception.Dose1NotTakenException;
import com.example.COVISHOT.exception.UserNotFoundException;
import com.example.COVISHOT.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public AppointmentResponseDto bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, Dose1NotTakenException {

        return appointmentService.bookAppointment(appointmentRequestDto);

//        try{
//            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
//            return new ResponseEntity(appointmentResponseDto, HttpStatus.CREATED);
//        }
//        catch(UserNotFoundException e){
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        catch(DoctorNotFoundException e){
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        catch(Dose1NotTakenException e){
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
    }
}
