package com.example.COVISHOT.transformer;

import com.example.COVISHOT.dto.RequestDTO.UserRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.UserResponseDto;
import com.example.COVISHOT.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {

    public static User UserRequestDtoToUser(UserRequestDto userRequestDto){

        return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .emailId(userRequestDto.getEmailId())
                .gender(userRequestDto.getGender())
                .mobNo(userRequestDto.getMobNo())
                .build();
    }

    public static UserResponseDto UserToUserResponseDto(User user){

        return UserResponseDto.builder()
                .name(user.getName())
                .message("Congrats "+user.getName()+"! You have Successfully registered on COVISHOT")
                .build();
    }
}
