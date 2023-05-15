package com.example.COVISHOT.repository;

import com.example.COVISHOT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * from user WHERE email_id = :emailId", nativeQuery = true)
    User findByEmailId(String emailId);

    @Query(value = "SELECT * FROM user WHERE mob_no = :mobNo", nativeQuery = true)
    User findByMobNo(String mobNo);

    @Query(value = "SELECT * FROM user WHERE is_dose1_taken = '0' AND is_dose2_taken = '0'", nativeQuery = true)
    List<User> usersNotTakenAnyDose();

    @Query(value = "SELECT * FROM user WHERE is_dose1_taken = '1' AND is_dose2_taken = '0'", nativeQuery = true)
    List<User> usersTakenDose1ButNotDose2();

    @Query(value = "SELECT * FROM user WHERE is_dose1_taken = '1' AND is_dose2_taken = '1'", nativeQuery = true)
    List<User> fullyVaccinatedUsers();

    @Query(value = "SELECT * FROM user WHERE gender = 'MALE' AND is_dose1_taken = '0' AND is_dose2_taken = '0'", nativeQuery = true)
    List<User> maleWithNotASingleDose();

    @Query(value = "SELECT * FROM user WHERE gender = 'FEMALE' AND is_dose1_taken = '1' AND is_dose2_taken = '1'", nativeQuery = true)
    List<User> fullyVaccinatedFemales();

}
