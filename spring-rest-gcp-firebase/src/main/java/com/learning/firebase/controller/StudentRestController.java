package com.learning.firebase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learning.firebase.model.StudentDTO;
import com.learning.firebase.service.StudentService;

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
	public boolean storeStudentToFirebase(@RequestBody StudentDTO studentDTO) throws JsonProcessingException {
		return studentService.saveStudent(studentDTO);
	}
	
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
