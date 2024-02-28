package com.example.COVISHOT.service;

import com.example.COVISHOT.Enum.VaccineType;
import com.example.COVISHOT.model.Dose2;
import com.example.COVISHOT.model.User;

public interface Dose2Service {

    public Dose2 createDose2(User user, VaccineType vaccineType);
}
