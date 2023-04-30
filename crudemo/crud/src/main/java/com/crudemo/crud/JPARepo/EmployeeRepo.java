package com.crudemo.crud.JPARepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.crudemo.crud.entity.Employee;

//with this code we use the jpa spring built in function, and entends the jparepository with the type of the element 
//and the primary key, that in this case is an int
//the enpoint that we want for the employees
@RepositoryRestResource(path="members")         //entity type--primary key
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    //there is no need to write any code like we did for the DAO implementation
    //every thing is built in
}
