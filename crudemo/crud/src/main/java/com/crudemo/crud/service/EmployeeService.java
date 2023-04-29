package com.crudemo.crud.service;

import java.util.List;

import com.crudemo.crud.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);

}
