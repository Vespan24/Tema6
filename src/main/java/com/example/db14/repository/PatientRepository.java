package com.example.db14.repository;

import com.example.db14.model.Doctor;
import com.example.db14.model.Patient;
import com.example.db14.model.Specialty;
import com.example.db14.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
    Patient getById(Integer id);
    Patient getByCnp(String cnp);
    List<Patient> getAllByDoctor(Doctor doctor);
}
