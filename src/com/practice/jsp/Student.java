package com.practice.jsp;

public class Student {
	
	private int id;
	private String name;
	private String fatherName;
	private String motherName;
	private String address;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, String fatherName, String motherName, String address) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", address=" + address + "}";
	}
	
	

}
