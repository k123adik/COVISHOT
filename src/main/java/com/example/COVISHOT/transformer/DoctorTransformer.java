package com.example.COVISHOT.transformer;

import com.example.COVISHOT.dto.RequestDTO.DoctorRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.model.Doctor;

public class DoctorTransformer {

    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){

        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();
    }

    public static DoctorResponseDto DoctorToDoctorResponseDto(Doctor doctor) {

        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.centerToCenterResponseDto(doctor.getVaccinationCenter());

        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .vaccinationCenterResponseDto(vaccinationCenterResponseDto)
                .build();
    }


}
