package com.example.demo.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ConcurrentUpdateTestCollection")
public class ConcurrentUpdateTestCollection {
	@Id
	public String id;

	public String name;
	public String sname;
	
	@Override
	public String toString() {
		return "ConcurrentUpdateTestCollection [id=" + id + ", name=" + name + ", sname=" + sname + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

}
