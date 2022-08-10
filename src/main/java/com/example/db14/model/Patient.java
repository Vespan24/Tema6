package com.example.db14.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.Doc;
import javax.xml.bind.Unmarshaller;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient extends Observable {
    @Id
    @GeneratedValue
    Integer id;
    @NotNull
    String cnp;
    @OneToMany
    List<Visit> visitList = new ArrayList<>();

    @NotNull
    @ManyToOne
    Doctor doctor;
    @Transient
    PatientObserver patientObserver;

    public void setDoctor(Doctor doctor){
        this.doctor=doctor;
        patientObserver.update(this, patientObserver);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public PatientObserver getPatientObserver() {
        return patientObserver;
    }

    public void setPatientObserver(PatientObserver patientObserver) {
        this.patientObserver = patientObserver;
    }
}