package com.hibernate.hibernate.DAO;

import java.util.List;

import com.hibernate.hibernate.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstname(String firstName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
    
}
