package com.example.COVISHOT.service.impl;

import com.example.COVISHOT.dto.RequestDTO.DoctorRequestDto;
import com.example.COVISHOT.dto.ResponseDTO.DoctorResponseDto;
import com.example.COVISHOT.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.COVISHOT.exception.CenterNotPresentException;
import com.example.COVISHOT.model.Doctor;
import com.example.COVISHOT.model.VaccinationCenter;
import com.example.COVISHOT.repository.DoctorRepository;
import com.example.COVISHOT.repository.VaccinationCenterRepo;
import com.example.COVISHOT.service.DoctorService;
import com.example.COVISHOT.transformer.DoctorTransformer;
import com.example.COVISHOT.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {

        Optional<VaccinationCenter> optionalCenter = vaccinationCenterRepo.findById(doctorRequestDto.getCenterId());

        if(!optionalCenter.isPresent()){
            throw new CenterNotPresentException("Invalid Center Id");
        }

        VaccinationCenter center = optionalCenter.get();

        //dto to entity
        Doctor doctor = DoctorTransformer.doctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setVaccinationCenter(center);

        //add doctor to the list of doctors at that center
        center.getDoctors().add(doctor);

        VaccinationCenter savedCenter = vaccinationCenterRepo.save(center);//saves both center and doctor

        //prepare response dto
//        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.centerToCenterResponseDto(savedCenter);


        return DoctorTransformer.DoctorToDoctorResponseDto(doctor);
    }

    @Override
    public List<String> doctorsMoreThan10Appointments() {

        List<Doctor> list = doctorRepository.doctorslist();

        List<String> ans = new ArrayList<>();
        for(Doctor doctor : list){
            if(doctor.getAppointments().size() >= 10){
                ans.add(doctor.getName());
            }
        }
        return ans;
    }

    @Override
    public List<String> maleDoctorsAgeGreaterThan40() {

        List<Doctor> list = doctorRepository.maleDoctorsAgeGreaterThan40();

        List<String> ans = new ArrayList<>();
        for(Doctor doctor : list){
           ans.add(doctor.getName());
        }
        return ans;
    }

    @Override
    public DoctorResponseDto updateDoctorById(Integer id, DoctorRequestDto doctorRequestDto) {

        //find doctor
        Doctor doctor = doctorRepository.findById(id).get();

        //update details in new doctor
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setName(doctorRequestDto.getName());
        doctor.setMobNo(doctorRequestDto.getMobNo());

        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorTransformer.DoctorToDoctorResponseDto(savedDoctor);

    }

    @Override
    public double getDoctorsMaleToFemaleRatio() {

        List<Doctor> maleDoctors = doctorRepository.getAllDoctorsWithGender("male");
        List<Doctor> femaleDoctors = doctorRepository.getAllDoctorsWithGender("female");

        double ans = maleDoctors.size() / femaleDoctors.size();

        return ans;
    }

    @Override
    public String deleteDoctorById(Integer id){

        doctorRepository.deleteById(id);
        return "The doctor with id :" + id + " has been deleted successfully!!";
    }
}
