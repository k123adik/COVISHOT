package com.example.COVISHOT.service.impl;

import com.example.COVISHOT.Enum.VaccineType;
import com.example.COVISHOT.model.Dose1;
import com.example.COVISHOT.model.User;
import com.example.COVISHOT.repository.Dose1Repository;
import com.example.COVISHOT.service.Dose1Service;
import com.example.COVISHOT.transformer.Dose1Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {

    @Autowired
    Dose1Repository dose1Repository;
    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {

        Dose1 dose1 = Dose1Transformer.createDose1(user, vaccineType);

        Dose1 savedDose1 = dose1Repository.save(dose1);

        return savedDose1;
    }
}
