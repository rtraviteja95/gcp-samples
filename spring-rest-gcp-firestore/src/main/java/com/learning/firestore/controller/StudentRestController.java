package com.learning.firestore.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.Timestamp;
import com.learning.firestore.model.StudentDTO;
import com.learning.firestore.service.StudentService;

/***
 * Controller class that exposes end points for Student
 * CRUD Operations on Firebase.
 * 
 * @author Ravi Teja
 *
 */
@RestController("/student")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudent")
	public Timestamp storeStudentToFirebase(@RequestBody StudentDTO studentDTO) throws InterruptedException, ExecutionException {
		return studentService.saveStudent(studentDTO);
	}
	
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
