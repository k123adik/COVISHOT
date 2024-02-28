package com.example.COVISHOT.service.impl;

import com.example.COVISHOT.dto.RequestDTO.UserRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.UserDetailsDto;
import com.example.COVISHOT.dto.ResponseDTO.UserListDTO;
import com.example.COVISHOT.dto.ResponseDTO.UserResponseDto;
import com.example.COVISHOT.model.User;
import com.example.COVISHOT.repository.UserRepository;
import com.example.COVISHOT.service.UserService;
import com.example.COVISHOT.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        User user = UserTransformer.UserRequestDtoToUser(userRequestDto);

        //save the object
        User savedUser = userRepository.save(user);

        //convert entity to responseDto

        UserResponseDto userResponseDto = UserTransformer.UserToUserResponseDto(savedUser);

        return userResponseDto;
    }

    @Override
    public UserDetailsDto findByEmailId(String emailId) {

        User user = userRepository.findByEmailId(emailId);

        UserDetailsDto userDetailsDto = new UserDetailsDto();

        userDetailsDto.setName(user.getName());
        userDetailsDto.setAge(user.getAge());
        userDetailsDto.setGender(user.getGender());

        if(user.isDose1Taken() == false){
            userDetailsDto.setIsDose1Taken("NO");
        }
        else{
            userDetailsDto.setIsDose1Taken("YES");
        }
        if(user.isDose2Taken() == false){
            userDetailsDto.setIsDose2Taken("NO");
        }
        else{
            userDetailsDto.setIsDose2Taken("YES");
        }

        return userDetailsDto;
    }

    @Override
    public UserResponseDto updateNameByMobNo(String mobNo, String name) {

        //find user by mob no
        User updateUser = userRepository.findByMobNo(mobNo);
        //update name of user
        updateUser.setName(name);
        //save details in database
        User savedUser = userRepository.save(updateUser);

        //convert entity to responseDTO
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(savedUser.getName());
        userResponseDto.setMessage("Congrats "+ savedUser.getName() + "! Name updated Successfully");

        return userResponseDto;
    }

    @Override
    public UserListDTO userNotTakenAnyDose() {

        List<User> list = userRepository.usersNotTakenAnyDose();
        List<String> ans = new ArrayList<>();

        for(User user : list){
            ans.add(user.getName());
        }

        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setMessage("The names of the users who have not taken any dose are:");
        userListDTO.setList(ans);


        return userListDTO;
    }

    @Override
    public UserListDTO usersTakenDose1ButNotDose2() {

        List<User> list = userRepository.usersTakenDose1ButNotDose2();
        List<String> ans = new ArrayList<>();

        for(User user : list){
            ans.add(user.getName());
        }

        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setMessage("The names of the users who have taken only dose 1:");
        userListDTO.setList(ans);

        return userListDTO;

    }

    @Override
    public UserListDTO fullyVaccinatedUsers() {
        List<User> list = userRepository.fullyVaccinatedUsers();
        List<String> ans = new ArrayList<>();

        for(User user : list){
            ans.add(user.getName());
        }

        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setMessage("The names Fully Vaccinated Users:");
        userListDTO.setList(ans);

        return userListDTO;
    }

    @Override
    public UserListDTO maleWithNotASingleDose() {

        List<User> list = userRepository.maleWithNotASingleDose();
        List<String> ans = new ArrayList<>();

        for(User user : list){
            ans.add(user.getName());
        }

        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setMessage("The names of males with not a single dose:");
        userListDTO.setList(ans);

        return userListDTO;
    }

    @Override
    public UserListDTO fullyVaccinatedFemales() {

        List<User> list = userRepository.fullyVaccinatedFemales();
        List<String> ans = new ArrayList<>();

        for(User user : list){
            ans.add(user.getName());
        }

        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setMessage("The names Fully Vaccinated Females:");
        userListDTO.setList(ans);

        return userListDTO;
    }


}
