package com.example.COVISHOT.service;

import com.example.COVISHOT.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;

import java.util.List;

public interface VaccinationCenterService {

    public VaccinationCenterResponseDto addCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto);

    public List<DoctorResponseDto> getAllDoctorsAtCenter(Integer id);

    public List<DoctorResponseDto> getAllGenderDoctorsAtCenterAgeAboveX(String gender, Integer age, Integer id);
}
