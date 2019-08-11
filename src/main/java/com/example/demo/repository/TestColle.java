package com.example.demo.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testColle")
public class TestColle {
	@Id
	public String id;

	public String name;
	public String sname;

	public TestColle() {}

	public TestColle(String firstName, String lastName) {
	        this.name = firstName;
	        this.sname = lastName;
	    }

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, name, sname);
	}
}
