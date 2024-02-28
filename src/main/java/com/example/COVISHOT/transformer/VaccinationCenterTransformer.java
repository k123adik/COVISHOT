package com.example.COVISHOT.transformer;

import com.example.COVISHOT.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.model.VaccinationCenter;

public class VaccinationCenterTransformer {

    public static VaccinationCenter CenterRequestDtoToCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto){

        return VaccinationCenter.builder()
                .name(vaccinationCenterRequestDto.getName())
                .location(vaccinationCenterRequestDto.getLocation())
                .centerType(vaccinationCenterRequestDto.getCenterType())
                .build();
    }

    public static VaccinationCenterResponseDto centerToCenterResponseDto(VaccinationCenter vaccinationCenter){

        return VaccinationCenterResponseDto.builder()
                .name(vaccinationCenter.getName())
                .location(vaccinationCenter.getLocation())
                .centerType(vaccinationCenter.getCenterType())
                .build();
    }
}
