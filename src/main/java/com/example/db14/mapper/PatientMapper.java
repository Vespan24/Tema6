package com.example.db14.mapper;

import com.example.db14.dto.PatientDto;
import com.example.db14.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PatientMapper {
    PatientDto topatientDto (Patient patient);

}
