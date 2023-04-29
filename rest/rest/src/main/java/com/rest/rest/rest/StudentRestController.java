package com.rest.rest.rest;

import java.util.*;

import javax.annotation.PostConstruct;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //we needto define a field that will have the data, and we do it only once
    private List<Student> students;
    //then we load the students list with some data, using the @PostConstruct to load the student data, only once
    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("Mario", "Rossi" ));
        students.add(new Student("Luigi", "Verdi" ));
        students.add(new Student("Cinzia", "Blu" ));
    }

    //define endpoint that return all the students
    @GetMapping("/students")
    public List<Student> getStudent(){
        //like this we create a List of student every time we run the application,and it's not the best practice
        // List<Student> students=new ArrayList<>();
        // students.add(new Student("Mario", "Rossi" ));
        // students.add(new Student("Luigi", "Verdi" ));
        // students.add(new Student("Cinzia", "Blu" ));

        //thanks to the post construct annotation we don't need to add student in the list every time we access the endpoint
        return students;
    }

    //endpoint for returniing only one student, based on the index
    //@PATHVAriable will link the parameter to the url endpoint that contains the '{}' in the name
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //if the id is bigger than the size we throw the student not found exception
        if(studentId>=students.size() || students.size()<=0) throw new StudentNotFoundException("Student not found for id: " + studentId);
        return students.get(studentId);
    }

    //with this we handle the exception handler method
    //StudentErrorResponse is the response body
    //except is what exception type we handle
    //we comment this part of code because we use the excpetionhandler as global excpetion
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException except){
        
    //     //create a studentError response
    //     StudentErrorResponse error=new StudentErrorResponse();
    //     error.setStatus(404);
    //     error.setMessage("Student not found");
    //     error.setTimeStamp(System.currentTimeMillis());
    //     //return response entity
        
    //     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    // }

    // //AD ANOTHER EXCEPTION HANDLER.. that controll all type of exception
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(Exception except){
    //      //create a studentError response
    //      StudentErrorResponse error=new StudentErrorResponse();
    //      error.setStatus(HttpStatus.BAD_REQUEST.value());
    //      error.setMessage(except.getMessage());
    //      error.setTimeStamp(System.currentTimeMillis());
    //      //return response entity
         
    //      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    // }
}
