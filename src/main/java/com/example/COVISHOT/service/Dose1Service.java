package com.example.COVISHOT.service;

import com.example.COVISHOT.Enum.VaccineType;
import com.example.COVISHOT.model.Dose1;
import com.example.COVISHOT.model.User;

public interface Dose1Service {

    public Dose1 createDose1(User user, VaccineType vaccineType);
}
