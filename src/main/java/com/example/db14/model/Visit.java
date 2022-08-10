package com.example.db14.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    @Id
    @GeneratedValue
    Integer id;
    @NotNull
    Date date;
    @ManyToOne
    Patient patient;
    @ManyToOne
    Doctor doctor;
}