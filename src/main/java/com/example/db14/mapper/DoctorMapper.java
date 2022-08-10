package com.example.db14.mapper;

import com.example.db14.dto.DoctorDto;
import com.example.db14.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DoctorMapper {
    DoctorDto todoctorDto (Doctor doctor);

}
