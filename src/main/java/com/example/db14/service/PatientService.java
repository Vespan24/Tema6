package com.example.db14.service;

import com.example.db14.exceptions.NoPatientException;
import com.example.db14.exceptions.NoSpecialtyException;
import com.example.db14.model.Doctor;
import com.example.db14.model.Patient;
import com.example.db14.model.Specialty;
import com.example.db14.model.Visit;
import com.example.db14.repository.PatientRepository;
import com.example.db14.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    final PatientRepository patientRepository;
    final VisitRepository visitRepository;

    public Patient getPatientById(Integer Id){
        return patientRepository.getById(Id);
    }

    public Patient getPatientByCnp(String cnp){
        return patientRepository.getByCnp(cnp);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public List<Patient> getAllByDoctor(Doctor doctor){
        return patientRepository.getAllByDoctor(doctor);
    }

    public List<Visit> getAllVisitsByCnpAndSpecialty(String cnp, Specialty specialty) throws NoPatientException, NoSpecialtyException {
        Patient p = patientRepository.getByCnp(cnp);
        if (p == null) {
            throw new NoPatientException();
        } else {
            Specialty s = p.getDoctor().getSpecialty();
            if (s != specialty)
                throw new NoSpecialtyException();
            else
                return visitRepository.getAllByPatient(p);
        }

    }
}
