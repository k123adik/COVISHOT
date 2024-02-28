package com.example.COVISHOT.service.impl;

import com.example.COVISHOT.Enum.DoseNo;
import com.example.COVISHOT.dto.RequestDTO.AppointmentRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.AppointmentResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.exception.DoctorNotFoundException;
import com.example.COVISHOT.exception.Dose1NotTakenException;
import com.example.COVISHOT.exception.UserNotFoundException;
import com.example.COVISHOT.model.*;
import com.example.COVISHOT.repository.AppointmentRepository;
import com.example.COVISHOT.repository.DoctorRepository;
import com.example.COVISHOT.repository.UserRepository;
import com.example.COVISHOT.service.AppointmentService;
import com.example.COVISHOT.service.Dose1Service;
import com.example.COVISHOT.service.Dose2Service;
import com.example.COVISHOT.transformer.AppointmentTransformer;
import com.example.COVISHOT.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    Dose1Service dose1Service;

    @Autowired
    Dose2Service dose2Service;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto  appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, Dose1NotTakenException {

        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User does not exist!");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(!optionalUser.isPresent()){
            throw new DoctorNotFoundException("Doctor does not exist!");
        }

        User user = optionalUser.get();
        Doctor doctor = optionalDoctor.get();

        if(appointmentRequestDto.getDoseNo() == DoseNo.DOSE_1){
            Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }
        else {
            if(user.isDose1Taken() == false){
                throw new Dose1NotTakenException("Please take Dose1 first!");
            }

            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);

        }

        Appointment appointment = AppointmentTransformer.AppointmentRequestDtoToAppointment(appointmentRequestDto, user, doctor);

//        doctor.getAppointments().add(appointment);
        user.getAppointments().add(appointment);

//        Appointment savedAppointment = appointmentRepository.save(appointment);

        User savedUser = userRepository.save(user);

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);
        doctor.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);

        //send email

        String text = "Congrats!"+ user.getName() + " Your dose" + appointmentRequestDto.getDoseNo() + " has been booked!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked");
        message.setText(text);
        emailSender.send(message);

        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.centerToCenterResponseDto(doctor.getVaccinationCenter());

        AppointmentResponseDto appointmentResponseDto = AppointmentTransformer.AppointmentToAppointmentResponseDto(savedAppointment, user, doctor);


        appointmentResponseDto.setVaccinationCenterResponseDto(vaccinationCenterResponseDto);
        appointmentResponseDto.setVaccineType(appointmentRequestDto.getVaccineType());
//        appointmentResponseDto.setDateOfAppointment(savedAppointment.getDateOfAppointment());

        return appointmentResponseDto;

    }
}
