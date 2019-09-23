package com.learning.firestore.model;

/***
 * 
 * Student Model class
 * 
 * @author Ravi Teja
 *
 */
public class StudentDTO {
	
	private String name;
	
	private String location;
	
	public StudentDTO() {
		//--Default Constructor--
	}

	public StudentDTO(int studentId, String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
