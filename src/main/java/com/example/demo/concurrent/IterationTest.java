package com.example.demo.concurrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.TestColl;
import com.example.demo.repository.TestColle;

//@Component
public class IterationTest implements CommandLineRunner {
	@Autowired
	private TestColl repository;

	/* 
	 * Given : All record fetched by repository and forEach loop is in progress. 
	 * When  : Meanwhile another thread adding record in same collection.
	 * Then : There is no impact on running forEach loop, it is not showing latest result.   
	 * */
	@Override
	public void run(String... args) throws Exception {
		try {

			System.out.println("Test collection found with findAll():");

			for (TestColle testCollection : repository.findAll()) {
				System.out.println(testCollection);
				System.out.println("--Thread Sleep start, insert new document by mongo shell---------------");
				try {
					System.out.println(" Sleep start ");
					Thread.sleep(5000);
					System.out.println(" Sleep end ");
				} catch (Exception e) {
					System.out.println(" Exception : " + e);
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			System.out.println(" Exception_2 : " + e);
			e.printStackTrace();
		}
	}

}
