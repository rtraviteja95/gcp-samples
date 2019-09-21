package com.learning.firebase.config.yml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationYMLConfig {

	@Value("${application.configuration.firebase.serviceKeyFile}")
	private String serviceKeyFile;
	
	@Value("${application.configuration.firebase.databaseUrl}")
	private String databaseUrl;
	
	@Value("${application.configuration.firebase.databaseReference}")
	private String databaseReference;
	
	public ApplicationYMLConfig() {
		//---Default Constructor---
	}

	public String getServiceKeyFile() {
		return serviceKeyFile;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getDatabaseReference() {
		return databaseReference;
	}
	
}
