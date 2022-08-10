package com.example.db14.controller;

import com.example.db14.exceptions.NoPatientException;
import com.example.db14.exceptions.NoSpecialtyException;
import com.example.db14.model.Patient;
import com.example.db14.model.Specialty;
import com.example.db14.model.Visit;
import com.example.db14.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients/{Id}")
    public Patient getPatientById(@RequestParam Integer Id){
        return patientService.getPatientById(Id);
    }
    @GetMapping("/patients/{cnp}")
    public Patient getPatientByCnp(@RequestParam String cnp){
        return patientService.getPatientByCnp(cnp);
    }
    @GetMapping("/patients/all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{cnp}/{specialty}")

    public List<Visit> getAllVisitsByCnpAndSpecialty(@RequestParam String cnp, @RequestParam Specialty specialty) throws NoSpecialtyException, NoPatientException {
        return patientService.getAllVisitsByCnpAndSpecialty(cnp, specialty);
    }



}
