package com.company.workflowservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Spring MongoDB configuration file
 * 
 */
@Configuration
public class SpringMongoConfig{
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		List<ServerAddress> seeds= new ArrayList<>();
		seeds.add(new ServerAddress("ESPC007307", 27017));
		MongoClient mongo = new MongoClient(seeds);
		return new SimpleMongoDbFactory(mongo, "yourdb");
	}
	

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		
		MongoTemplate mongoTemplate = 
			new MongoTemplate(new MongoClient("ESPC007307"),"yourdb");
		return mongoTemplate;
		
	}
		
}
