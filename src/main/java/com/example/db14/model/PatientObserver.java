package com.example.db14.model;

import javax.xml.bind.Unmarshaller;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class PatientObserver implements Observer {
    @Override
    public void update(Observable o, Object arg){
        System.out.println("You have a new patient");
    }
}
