// package com.crudemo.crud.service;
//this can be deleted thanks to the rest jpa dependency
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.crudemo.crud.DAO.EmployeeDAO;
// import com.crudemo.crud.JPARepo.EmployeeRepo;
// import com.crudemo.crud.entity.Employee;

// @Service // anotation for the service implementation
// public class EmployeeServiceImpl implements EmployeeService {

//     // if using the DAO implementation
//     // private EmployeeDAO employeeDAO;

//     // @Autowired
//     // public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
//     // employeeDAO=theEmployeeDAO;
//     // }

//     // @Override
//     // public List<Employee> findAll() {
//     // return employeeDAO.findAll();
//     // }

//     // @Override
//     // public Employee findById(int id) {
//     // return employeeDAO.findById(id);
//     // }

//     // @Transactional
//     // @Override
//     // public Employee save(Employee employee) {
//     // return employeeDAO.save(employee);
//     // }

//     // @Transactional
//     // @Override
//     // public void delete(int id) {
//     // employeeDAO.delete(id);
//     // System.out.println("employee with id " + id + " has been deleted");
//     // }
//     // _--------------------
//     // if using the jpa repo implementation
//     // we can remove at @transactional
//     private EmployeeRepo employeeRepo;

//     @Autowired
//     public EmployeeServiceImpl(EmployeeRepo theEmployeeRepo) {
//         employeeRepo = theEmployeeRepo;
//     }

//     @Override
//     public List<Employee> findAll() {
//         return employeeRepo.findAll();
//     }

//     @Override
//     public Employee findById(int id) {
//         Optional<Employee> result = employeeRepo.findById(id);
//         Employee employee=null;
//         if(result.isPresent()){
//             employee=result.get();
//         }else{
//             throw new RuntimeException("EMPLOYEE NOT FOUND");
//         }
//         return employee;
//     }

//     @Override
//     public Employee save(Employee employee) {
//         return employeeRepo.save(employee);
//     }

//     @Override
//     public void delete(int id) {
//         employeeRepo.deleteById(id);
//         System.out.println("employee with id " + id + " has been deleted");
//     }

// }
