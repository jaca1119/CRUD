package com.itvsme.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(TextRepository repository)
//	{
//		return (args -> {
//			repository.save(new SimpleText("Test1"));
//			repository.save(new SimpleText("Test2"));
//			repository.save(new SimpleText("Test3"));
//			repository.save(new SimpleText("Test1"));
//
//			log.info("Text found by findAll():");
//			log.info("---------------------------");
//			for (SimpleText text : repository.findAll())
//			{
//				log.info(text.toString());
//			}
//			log.info("---------------------------");
//			SimpleText text = repository.findByID(2);
//			log.info("Text found by findById(2):");
//			log.info(text.toString());
//			log.info("---------------------------");
//			log.info("Text found by findByText(\"Test1\"):");
//			log.info("---------------------------");
//			repository.findByText("Test1").forEach(founded -> {
//				log.info(founded.toString());
//			});
//		});
//	}
}
