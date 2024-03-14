package com.ota.exam.note.core.exception;

public class GeneralServiceException extends RuntimeException{
    public GeneralServiceException(String error){
        super(error);
    }
}
