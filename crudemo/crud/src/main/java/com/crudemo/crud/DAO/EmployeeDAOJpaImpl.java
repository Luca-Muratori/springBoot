package com.crudemo.crud.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crudemo.crud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
 
    //define field for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entity){
        //provide item n the bean that we want to inject
        entityManager=entity;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> query=entityManager.createQuery("FROM Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees=query.getResultList();
        //return result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get employee
        Employee employee = entityManager.find(Employee.class, id);
        //return employee
        return employee;
    }

    //update an employee
    //no need for the transactional annotation
    //because it will be handled at service layer
    @Override
    public Employee save(Employee employee) {
       //save employee
        Employee dbEmployee = entityManager.merge(employee);
       //return the dbEMployee
       return dbEmployee;
    }

    //no need for the transactional annotation
    //because it will be handled at service layer
    @Override
    public void delete(int id) {
        //find by id
        Employee employee=entityManager.find(Employee.class, id);
        
        //remove employee
        entityManager.remove(employee);
    }
    
}
