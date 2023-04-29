package com.rest.rest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//make the excpetion handler code to be reused on more controller
@ControllerAdvice//controll the url and if it's not correct will expose the exception handler methods
public class StudentRestExceptionHandler {
    
    //add exception handling code
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException except){
        
        //create a studentError response
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(404);
        error.setMessage("Student not found");
        error.setTimeStamp(System.currentTimeMillis());
        //return response entity
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //AD ANOTHER EXCEPTION HANDLER.. that controll all type of exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception except){
         //create a studentError response
         StudentErrorResponse error=new StudentErrorResponse();
         error.setStatus(HttpStatus.BAD_REQUEST.value());
         error.setMessage(except.getMessage());
         error.setTimeStamp(System.currentTimeMillis());
         //return response entity
         
         return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
