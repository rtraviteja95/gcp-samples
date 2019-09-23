package com.learning.firestore.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.learning.firestore.config.yml.ApplicationYMLConfig;
import com.learning.firestore.model.Student;

/***
 * @author rtrav
 *
 */
@Repository
public class FirestoreRepository {

	private Firestore fireStore;

	@Autowired
	private ApplicationYMLConfig applicationYMLConfig;

	public FirestoreRepository(ApplicationYMLConfig applicationYMLConfig) throws IOException {
		this.applicationYMLConfig = applicationYMLConfig;

		initializeFirestore();
	}

	public void initializeFirestore() throws IOException {

		FileInputStream serviceAccount = new FileInputStream(this.applicationYMLConfig.getServiceKeyFile());

		FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setProjectId(this.applicationYMLConfig.getProjectId())
				.build();

		fireStore = firestoreOptions.getService();

	}

	public Timestamp saveStudent(Student student) throws InterruptedException, ExecutionException {
	
		DocumentReference documentReference = fireStore.collection(this.applicationYMLConfig.getCollectionName())
				.document(student.getStudentId());
		
		return documentReference.set(student).get().getUpdateTime();
	}
}
