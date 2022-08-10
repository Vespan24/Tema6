package com.example.db14.dto;

import com.example.db14.model.Doctor;
import com.example.db14.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    String name;
    Specialty specialty;

    public DoctorDto(Doctor doctor){
        this.name=doctor.getName();
        this.specialty=doctor.getSpecialty();
    }
}
