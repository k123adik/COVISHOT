package com.example.COVISHOT.service;

import com.example.COVISHOT.dto.RequestDTO.AppointmentRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.AppointmentResponseDto;
import com.example.COVISHOT.exception.DoctorNotFoundException;
import com.example.COVISHOT.exception.Dose1NotTakenException;
import com.example.COVISHOT.exception.UserNotFoundException;

public interface AppointmentService {

    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, Dose1NotTakenException;
}
