package com.example.COVISHOT.service.impl;

import com.example.COVISHOT.Enum.VaccineType;
import com.example.COVISHOT.model.Dose2;
import com.example.COVISHOT.model.User;
import com.example.COVISHOT.repository.Dose2Repository;
import com.example.COVISHOT.service.Dose2Service;
import com.example.COVISHOT.transformer.Dose2Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dose2ServiceImpl implements Dose2Service {

    @Autowired
    Dose2Repository dose2Repository;

    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {

        Dose2 dose2 = Dose2Transformer.createDose2(user, vaccineType);

        Dose2 savedDose2 = dose2Repository.save(dose2);

        return savedDose2;
    }
}
