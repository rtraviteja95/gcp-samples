package com.learning.firebase.model;

/***
 * 
 * Student Model class
 * 
 * @author Ravi Teja
 *
 */
public class Student {

	private String studentId;
	
	private String name;
	
	private String location;
	
	public Student() {
		//--Default Constructor--
	}

	public Student(String studentId, String name, String location) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.location = location;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
