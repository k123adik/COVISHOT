package com.example.COVISHOT.repository;

import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.model.Doctor;
import com.example.COVISHOT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "SELECT * FROM doctor", nativeQuery = true)
    List<Doctor> doctorslist();

    @Query(value = "SELECT * FROM doctor WHERE gender = 'MALE' AND age>=40", nativeQuery = true)
    List<Doctor> maleDoctorsAgeGreaterThan40();

    @Query(value = "SELECT * from user WHERE email_id = :emailId", nativeQuery = true)
    Doctor findByEmailId(String emailId);

    @Query(value = "SELECT * FROM doctor WHERE gender = :gender", nativeQuery = true)
    List<Doctor> getAllDoctorsWithGender(String gender);


    List<Doctor> findAllByGenderAndAgeAndVaccinationCenterId(String gender, Integer age, Integer id);

}
