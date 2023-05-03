package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	public EmployeeController(EmployeeService theEmployeeService){
		employeeService=theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		//get employees from database
		List<Employee> theEmployees=employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel){
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employeeForm";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
		//get the employee form the service
		Employee theEmployee=employeeService.findById(theId);
		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		//send over to the form
		return "/employees/employeeForm";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId, Model theModel){
		//get the employee form the service
		employeeService.deleteById(theId);
		//set employee in the model to prepopulate the form
		
		//send over to the form
		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		//save employee
		employeeService.save(theEmployee);
		//use a redirect to prevent duplicate
		return "redirect:/employees/list";
	}
	
}	









