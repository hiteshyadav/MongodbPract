package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.TestColl;
import com.example.demo.repository.TestColle;

@SpringBootApplication
public class MongoTransactionPracApplication {

	
	public static void main(String[] args) {
		try {
			SpringApplication.run(MongoTransactionPracApplication.class, args);

		} catch (Exception e) {
			System.out.println(" Exception_1 : " + e);
			e.printStackTrace();
		}

	}

}
