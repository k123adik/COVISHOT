package com.example.COVISHOT.dto.ResponseDTO;

import com.example.COVISHOT.Enum.DoseNo;
import com.example.COVISHOT.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String userName;

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    VaccinationCenterResponseDto vaccinationCenterResponseDto;

    String doctorName;

    VaccineType vaccineType;
}
