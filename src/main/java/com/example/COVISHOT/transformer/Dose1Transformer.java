package com.example.COVISHOT.transformer;

import com.example.COVISHOT.Enum.VaccineType;
import com.example.COVISHOT.model.Dose1;
import com.example.COVISHOT.model.User;

import java.util.UUID;

public class Dose1Transformer {

    public static Dose1 createDose1(User user, VaccineType vaccineType){

        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}
