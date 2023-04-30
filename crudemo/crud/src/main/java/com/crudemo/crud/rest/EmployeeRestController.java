// package com.crudemo.crud.rest;
//delete this because using spring rest jpa dependency in the pom.xml file
// import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.crudemo.crud.entity.Employee;
// import com.crudemo.crud.service.EmployeeService;

// @RestController
// @RequestMapping("/api")
// public class EmployeeRestController {

//     private EmployeeService employeeService;

//     //inject employee dao
//     public EmployeeRestController(EmployeeService theEmployeeDAO){
//         employeeService=theEmployeeDAO;
//     }

//     //expose /employees to return a list of employees
//     @GetMapping("/employees")
//     public List<Employee> getEmployees(){
//         return employeeService.findAll();
//     }

//     @GetMapping("/employees/{employeeId}")
//     public Employee getEmployee(@PathVariable int employeeId){
//         Employee employee = employeeService.findById(employeeId);
//         if(employee==null) throw new RuntimeException("employee not found");
//         return employee;
//     }

//     //add new employee
//     @PostMapping("/employees")
//     public Employee addEmployee(@RequestBody Employee employee){
//         employee.setId(0);
//         Employee dbEmployee=employeeService.save(employee);
//         return dbEmployee;
//     }

//     //add mapping for modifying employee
//     @PutMapping("/employees")
//     public Employee updateEmployee(@RequestBody Employee employee){
//         Employee dbEmployee = employeeService.save(employee);
//         return dbEmployee;
//     }

//     //delete an employee
//     @DeleteMapping("/employees/{employeeId}")
//     public String deleteEmployee(@PathVariable int employeeId){
//         Employee dbEmployee=employeeService.findById(employeeId);
//         //thorw exception if null
//         if(dbEmployee==null) throw new RuntimeException("Employee not found");

//         employeeService.delete(employeeId);

//         return "DELETED EMPLOY WITH ID " + employeeId;
//     }



// }
