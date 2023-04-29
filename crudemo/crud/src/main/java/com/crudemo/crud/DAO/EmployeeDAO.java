package com.crudemo.crud.DAO;

import java.util.List;

import com.crudemo.crud.entity.Employee;

public interface EmployeeDAO {

    List<Employee>findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
