package com.learning.firebase.repository;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.learning.firebase.config.yml.ApplicationYMLConfig;
import com.learning.firebase.model.Student;

@Repository
public class FirebaseRepository {

	private DatabaseReference databaseReference;

	private boolean flag = Boolean.FALSE;

	@Autowired
	private ApplicationYMLConfig applicationYMLConfig;

	public FirebaseRepository(ApplicationYMLConfig applicationYMLConfig) throws IOException {
		this.applicationYMLConfig = applicationYMLConfig;

		initializeFirebase();
	}

	public void initializeFirebase() throws IOException {
		// Fetch the service account key JSON file contents
		FileInputStream serviceAccount = new FileInputStream(this.applicationYMLConfig.getServiceKeyFile());

		// Initialize the app with a service account, granting admin privileges
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl(this.applicationYMLConfig.getDatabaseUrl())
				.build();
		FirebaseApp.initializeApp(options);

		this.databaseReference = FirebaseDatabase
				.getInstance()
				.getReference("/").child(this.applicationYMLConfig.getDatabaseReference());

	}

	public boolean saveStudent(Student student) throws JsonProcessingException {
		flag = Boolean.FALSE;

		databaseReference.child(student.getStudentId()).setValue(student, 
				new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
				if (databaseError != null) {
					System.out.println("Data could not be saved " + databaseError.getMessage());
					flag = Boolean.FALSE;
				} else {
					System.out.println("Data saved successfully.");
					flag = Boolean.TRUE;
				}
			}
		});

		return flag;

	}
}
