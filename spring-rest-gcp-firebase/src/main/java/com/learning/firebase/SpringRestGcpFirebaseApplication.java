package com.learning.firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * Application that exposes Rest Services that does CRUD Operations 
 * on Firebase.
 * 
 * @author Ravi Teja
 *
 */
@SpringBootApplication
public class SpringRestGcpFirebaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestGcpFirebaseApplication.class, args);
	}

}
