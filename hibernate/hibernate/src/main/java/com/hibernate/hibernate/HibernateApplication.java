package com.hibernate.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hibernate.hibernate.DAO.StudentDAO;
import com.hibernate.hibernate.entity.Student;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForFirstName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("deleting all student ");
		int itemsDeleted=studentDAO.deleteAll();
		System.out.println("Items deleted, n°:" + itemsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//retrieve student by id
		int studentId=3;
		System.out.println("getting student by id " + studentId);
		//deleting student
		System.out.println("deleting student");
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student by id
		int studentId=1;
		System.out.println("gETTING STUDENT BY ID " + studentId);
		Student myStudent=studentDAO.findById(studentId);
		//change first name to 'scooby'
		System.out.println("changing the first name...");
		myStudent.setFirstName("SCOOBY");
		//update the student
		studentDAO.update(myStudent);
		//display the updated student
		System.out.println("updated student: " + myStudent);

	}
	
	private void queryForFirstName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByFirstname("pop");
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students=studentDAO.findAll();
		for(Student student: students){
			System.out.println(student);
		}

		//display list of students
	}
	
	private void readStudent(StudentDAO studentDAO) {
		System.out.println("creating a new student...");
		Student tempStudent1=new Student("mark", "DOE", "DOE@IT");
		System.out.println("saving student");
		studentDAO.save(tempStudent1);

		int id=tempStudent1.getId();
		System.out.println("student with id: " + id);
		Student student=studentDAO.findById(id);
		System.out.println("student: " + student);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("creating a new student....");
		Student tempStudent1=new Student("mark", "DOE", "DOE@IT");
		Student tempStudent2=new Student("pop", "DOE", "DOE@IT");
		Student tempStudent3=new Student("bolo", "DOE", "DOE@IT");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("saving students");


	}
	
	private void createStudent(StudentDAO studentDAO) {
		System.out.println("creating a new student....");
		Student tempStudent=new Student("pAUL", "DOE", "DOE@IT");
		System.out.println("saving student...");
		studentDAO.save(tempStudent);

		System.out.println("generated id for the saved student: " + tempStudent.getId());
	}

	
}
