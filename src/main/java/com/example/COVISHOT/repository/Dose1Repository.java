package com.example.COVISHOT.repository;

import com.example.COVISHOT.model.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dose1Repository extends JpaRepository<Dose1, Integer> {
}
