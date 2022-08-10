package com.example.db14.exceptions;

public class NoDoctorException extends Exception{
    public NoDoctorException(){
        super("Doctor doesn't exist!");
    }
}
