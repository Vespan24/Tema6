package com.example.db14.service;

import com.example.db14.exceptions.NoDoctorException;
import com.example.db14.model.Doctor;
import com.example.db14.model.Patient;
import com.example.db14.model.Specialty;
import com.example.db14.repository.DoctorRepository;
import com.example.db14.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void addPatient(Integer doctorId, Integer patientId) throws NoDoctorException {
        Doctor d = doctorRepository.getById(doctorId);
        if (!d.isPresent())
            throw new NoDoctorException();
        else{
            Patient p=patientRepository.getById(patientId);
            if(p!=null){
                d.addPatient(p);
                p.setDoctor(d);
                doctorRepository.save(d);
            }
        }
    }
    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllBySpecialty(Specialty specialty) {
        return doctorRepository.getAllBySpecialty(specialty);
    }

}
