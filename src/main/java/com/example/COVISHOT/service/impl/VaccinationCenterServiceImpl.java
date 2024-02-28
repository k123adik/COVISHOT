package com.example.COVISHOT.service.impl;

import com.example.COVISHOT.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.model.Doctor;
import com.example.COVISHOT.model.VaccinationCenter;
import com.example.COVISHOT.repository.DoctorRepository;
import com.example.COVISHOT.repository.VaccinationCenterRepo;
import com.example.COVISHOT.service.VaccinationCenterService;
import com.example.COVISHOT.transformer.DoctorTransformer;
import com.example.COVISHOT.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public VaccinationCenterResponseDto addCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto) {

        //dto to entity
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDtoToCenter(vaccinationCenterRequestDto);

        //save to db
        VaccinationCenter savedCenter = vaccinationCenterRepo.save(vaccinationCenter);

        //entity to response dto

        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.centerToCenterResponseDto(savedCenter);

        return vaccinationCenterResponseDto;
    }

    @Override
    public List<DoctorResponseDto> getAllDoctorsAtCenter(Integer id) {

        Optional<VaccinationCenter> vaccinationCenter = vaccinationCenterRepo.findAllById(id);

        List<Doctor> doctors = vaccinationCenter.get().getDoctors();

        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();

        for(Doctor doctor : doctors){
            doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponseDto(doctor));
        }

        return doctorResponseDtos;
    }

    @Override
    public List<DoctorResponseDto> getAllGenderDoctorsAtCenterAgeAboveX(String gender, Integer age, Integer id) {

        List<Doctor> doctors = doctorRepository.findAllByGenderAndAgeAndVaccinationCenterId(gender, age, id);

        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();

        for(Doctor doctor : doctors){
            doctorResponseDtoList.add(DoctorTransformer.DoctorToDoctorResponseDto(doctor));
        }

        return doctorResponseDtoList;
    }
}
