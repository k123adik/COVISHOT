package com.example.COVISHOT.transformer;

import com.example.COVISHOT.dto.RequestDTO.AppointmentRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.AppointmentResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.model.Appointment;
import com.example.COVISHOT.model.Doctor;
import com.example.COVISHOT.model.User;

import java.util.UUID;

public class AppointmentTransformer {

    public static Appointment AppointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto, User user, Doctor doctor){

        return Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequestDto.getDoseNo())
                .user(user)
                .doctor(doctor)
                .build();
    }

    public static AppointmentResponseDto AppointmentToAppointmentResponseDto(Appointment appointment, User user, Doctor doctor){

        return AppointmentResponseDto.builder()
                .userName(user.getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .doctorName(doctor.getName())
                .build();
    }
}
