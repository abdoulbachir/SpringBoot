package com.bachir.cruddemo;

import com.bachir.cruddemo.dao.StudentDAO;
import com.bachir.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//readAllStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);

			//deleteAllTheStudents(studentDAO);
		};
	}

	private void deleteAllTheStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all the students");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 3;
		System.out.println("Deleting student id: "+studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int studentID = 1;
		System.out.println("Getting student with id: "+studentID);
		Student theStudent = studentDAO.findByID(studentID);

		//Change first name to "Scooby"
		System.out.println("Updating student ...");
		theStudent.setFirstName("Salim");

		//update student
		studentDAO.update(theStudent);

		//display the updated student
		System.out.println("Updated student "+theStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");
		
		//display the list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readAllStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("Salim", "ZOF", "salimzof@gmail.com");
		Student tempStudent2 = new Student("Mary", "Soriano", "mary@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonitaapplebum@gmail.com");

		//save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Bachir", "Zabeirou", "zabdoulbachir@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. Generated id: "+tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){

		//create a student object
		System.out.println("creating new student object");
		Student tempStudent = new Student("Daffy", "Duck", "duffyduck@gmail.com");

		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theID = tempStudent.getId();
		System.out.println("saved student. Generated id: "+ theID);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: "+theID);
		Student myStudent = studentDAO.findByID(theID);

		//display student
		System.out.println("Found the student: "+ myStudent);
	}

}
