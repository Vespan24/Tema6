package com.example.db14.repository;

import com.example.db14.model.Doctor;
import com.example.db14.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    List<Doctor> findAll();
    Doctor getById(Integer id);
    List<Doctor> getAllBySpecialty(Specialty specialty);
}
