package com.example.demo.concurrent;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.demo.repository.ConcurrentUpdateTestCollection;
import com.example.demo.repository.IConcurrentUpdateTestCollection;
import com.mongodb.client.result.UpdateResult;

@Component
public class CocurrentDocumentUpdateTest implements CommandLineRunner {
	@Autowired
	private IConcurrentUpdateTestCollection repository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println(" CocurrentDocumentUpdateTest++++++++ ");
//			repository.findOne({"name":"Hitesh"});
//			List<ConcurrentUpdateTestCollection> list = repository.findByName("Hitesh");
//			for (ConcurrentUpdateTestCollection obj : list) {
//				System.out.println(" Collection : " + obj);
//			}
			CountDownLatch latch = new CountDownLatch(2);

			Query query = new Query(Criteria.where("name").is("Hitesh"));
			Update update = new Update();
			update.set("name", "UpdatedFromFirstThread");

			new Thread() {
				public void run() {
					System.out.println(" Inside Run Method ");
					try {
						Query query = new Query(Criteria.where("name").is("Hitesh"));
						Update update = new Update();
						update.set("name", "UpdatedFromSecondThread");
						latch.countDown();
						UpdateResult result1 = mongoTemplate.updateFirst(query, update,
								ConcurrentUpdateTestCollection.class);
						System.out.println(" Result from second thread : " + result1);
					} catch (Exception e) {
						System.out.println(" Exception in second thread : " + e);
						e.printStackTrace();
					}

				}
			}.start();
			latch.countDown();
			UpdateResult result = mongoTemplate.updateFirst(query, update, ConcurrentUpdateTestCollection.class);
			System.out.println(" Result from first thread : " + result);
		} catch (Exception e) {
			System.out.println(" Exception in first thread : " + e);
			e.printStackTrace();
		}

	}

}
