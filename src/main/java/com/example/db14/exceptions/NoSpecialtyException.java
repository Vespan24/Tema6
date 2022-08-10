package com.example.db14.exceptions;

public class NoSpecialtyException extends Exception{
    public NoSpecialtyException(){
        super("Specialty doesn't exist!");
    }
}
