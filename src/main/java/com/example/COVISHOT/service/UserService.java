package com.example.COVISHOT.service;


import com.example.COVISHOT.dto.RequestDTO.UserRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.UserDetailsDto;
import com.example.COVISHOT.dto.ResponseDTO.UserListDTO;
import com.example.COVISHOT.dto.ResponseDTO.UserResponseDto;

public interface UserService {

    public UserResponseDto addUser(UserRequestDto userRequestDto);

    public UserDetailsDto findByEmailId(String emailId);

    public UserResponseDto updateNameByMobNo(String mobNo, String name);

    public UserListDTO userNotTakenAnyDose();

    public UserListDTO usersTakenDose1ButNotDose2();

    public UserListDTO fullyVaccinatedUsers();

    public UserListDTO maleWithNotASingleDose();

    public UserListDTO fullyVaccinatedFemales();
}
