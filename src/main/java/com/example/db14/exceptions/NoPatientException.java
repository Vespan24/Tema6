package com.example.db14.exceptions;

public class NoPatientException extends Throwable {
    public NoPatientException(){
        super("Patient doesn't exist!");
    }
}
