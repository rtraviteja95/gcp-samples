package com.learning.firestore.service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.Timestamp;
import com.learning.firestore.model.Student;
import com.learning.firestore.model.StudentDTO;
import com.learning.firestore.repository.FirestoreRepository;

@Service
public class StudentService {

	@Autowired
	private FirestoreRepository firestoreRepository;
	
	public Timestamp saveStudent(StudentDTO studentDTO) throws InterruptedException, ExecutionException {
		return firestoreRepository.saveStudent(new Student(UUID.randomUUID().toString(),
				studentDTO.getName(),
				studentDTO.getLocation()));
	}
	
	public StudentService(FirestoreRepository firebaseRepository) {
		this.firestoreRepository = firebaseRepository;
	}
	
}
