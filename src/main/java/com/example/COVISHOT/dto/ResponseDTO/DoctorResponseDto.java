package com.example.COVISHOT.dto.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDto {

    String name;

    String emailId;

    String mobNo;

    VaccinationCenterResponseDto vaccinationCenterResponseDto;
}
