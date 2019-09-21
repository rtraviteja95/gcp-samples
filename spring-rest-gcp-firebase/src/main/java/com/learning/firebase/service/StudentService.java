package com.learning.firebase.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learning.firebase.model.Student;
import com.learning.firebase.model.StudentDTO;
import com.learning.firebase.repository.FirebaseRepository;

@Service
public class StudentService {

	@Autowired
	private FirebaseRepository firebaseRepository;
	
	public boolean saveStudent(StudentDTO studentDTO) throws JsonProcessingException {
		return firebaseRepository.saveStudent(new Student(UUID.randomUUID().toString(),
				studentDTO.getName(),
				studentDTO.getLocation()));
	}
	
	public StudentService(FirebaseRepository firebaseRepository) {
		this.firebaseRepository = firebaseRepository;
	}
	
}
