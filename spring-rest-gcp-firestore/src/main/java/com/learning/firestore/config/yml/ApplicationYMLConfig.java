package com.learning.firestore.config.yml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationYMLConfig {

	@Value("${application.configuration.firestore.serviceKeyFile}")
	private String serviceKeyFile;
	
	@Value("${application.configuration.firestore.projectId}")
	private String projectId;
	
	@Value("${application.configuration.firestore.collectionName}")
	private String collectionName;
	
	public ApplicationYMLConfig() {
		//---Default Constructor---
	}

	public String getServiceKeyFile() {
		return serviceKeyFile;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getCollectionName() {
		return collectionName;
	}

}
