package com.example.COVISHOT.dto.ResponseDTO;

import com.example.COVISHOT.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class VaccinationCenterResponseDto {

    String name;

    String location;

    CenterType centerType;

}
