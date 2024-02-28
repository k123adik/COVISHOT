package com.example.COVISHOT.service;

import com.example.COVISHOT.dto.RequestDTO.DoctorRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.exception.CenterNotPresentException;
import com.example.COVISHOT.model.Doctor;
import jakarta.validation.constraints.Email;

import java.util.List;

public interface DoctorService {

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;

    public List<String> doctorsMoreThan10Appointments();

    public List<String> maleDoctorsAgeGreaterThan40();

    public DoctorResponseDto updateDoctorById(Integer id, DoctorRequestDto doctorRequestDto);

    public double getDoctorsMaleToFemaleRatio();

    public String deleteDoctorById(Integer id);

}
