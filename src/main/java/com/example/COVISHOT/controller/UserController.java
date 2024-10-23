package com.example.COVISHOT.controller;

import com.example.COVISHOT.dto.RequestDTO.UserRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.UserDetailsDto;
import com.example.COVISHOT.dto.ResponseDTO.UserListDTO;
import com.example.COVISHOT.dto.ResponseDTO.UserResponseDto;
import com.example.COVISHOT.model.User;
import com.example.COVISHOT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")

    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_email_id")
    public ResponseEntity getUserByEmailId(@RequestParam("emailId")String emailId){

        UserDetailsDto userDetailsDto = userService.findByEmailId(emailId);
        return new ResponseEntity(userDetailsDto, HttpStatus.FOUND);
    }

    @PutMapping("/update_name_by_mobNo")
    public ResponseEntity updateNameNyMobNo(@RequestParam String mobNo, @RequestParam String name){

        UserResponseDto userResponseDto = userService.updateNameByMobNo(mobNo, name);
        return new ResponseEntity(userResponseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users_have_not_taken_any_dose")
    public ResponseEntity usersNotTakenAnyDose(){

        UserListDTO userListDTO = userService.userNotTakenAnyDose();
        return new ResponseEntity(userListDTO, HttpStatus.FOUND);
    }

    @GetMapping("/users_taken_dose1_but_dose2")
    public ResponseEntity usersTakenDose1ButNotDose2(){

        UserListDTO userListDTO = userService.usersTakenDose1ButNotDose2();
        return new ResponseEntity(userListDTO, HttpStatus.FOUND);
    }

    @GetMapping("/fully_vaccinated_users")
    public ResponseEntity fullyVaccinatedUsers(){

        UserListDTO userListDTO = userService.fullyVaccinatedUsers();
        return new ResponseEntity(userListDTO, HttpStatus.FOUND);

    }
    @GetMapping("/male_with_not_a_single_dose")
    public ResponseEntity maleWithNotASingleDose(){

        UserListDTO userListDTO = userService.maleWithNotASingleDose();
        return new ResponseEntity(userListDTO, HttpStatus.FOUND);
    }

    @GetMapping("/fully_vaccinated_females")
    public ResponseEntity fullyVaccinatedFemales(){

        UserListDTO userListDTO = userService.fullyVaccinatedFemales();
        return new ResponseEntity(userListDTO, HttpStatus.FOUND);
    }
}
