package com.bob.courses;

public class NoSuchCourseExistsException extends RuntimeException{
    private String message;
    public NoSuchCourseExistsException(){

    }
    public NoSuchCourseExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}
