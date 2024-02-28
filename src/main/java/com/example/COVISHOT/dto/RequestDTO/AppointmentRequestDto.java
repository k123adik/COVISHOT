package com.example.COVISHOT.dto.RequestDTO;

import com.example.COVISHOT.Enum.DoseNo;
import com.example.COVISHOT.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {

    DoseNo doseNo;

    int userId;

    int doctorId;

    VaccineType vaccineType;
}
