package com.example.COVISHOT.repository;

import com.example.COVISHOT.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {

    Optional<VaccinationCenter> findAllById(Integer id);
}
