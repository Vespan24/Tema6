package com.example.db14.controller;

import com.example.db14.dto.PatientDto;
import com.example.db14.exceptions.NoDoctorException;
import com.example.db14.model.Doctor;
import com.example.db14.model.Specialty;
import com.example.db14.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors/all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping(path="/doctors/addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable("doctorId")Integer doctorId, @PathVariable("patientId") Integer patientId) throws NoDoctorException {
        doctorService.addPatient(doctorId, patientId);
    }

    @GetMapping("/doctors/all?specialty={specialty}")
    public List<Doctor> getAllBySpecialty(@RequestParam Specialty specialty){
       return doctorService.getAllBySpecialty(specialty);
    }

    @PostMapping(path="/doctors/adddoctor/")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }


}
