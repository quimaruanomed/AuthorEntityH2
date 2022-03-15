package com.example.AuthorEntityH2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class ApplicationCommandRunner implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	AuthorService authorservice;


	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner");


		Author author1 = new Author ("1", "Paulo Coelho","Rio de Janeiro", 1947, 023, false);
		Author author2 = new Author ("2", "Isabel Allende", "Lima", 1942, 143, false);
		Author author3 = new Author ("3", "Stephen King","Portland", 1947, 204, false);
		Author author4 = new Author ("4", "Miguel Delibes","Valladolid", 1920, 150, false);
		Author author6 = new Author ("6", "Merce Rodoreda","Barcelona", 1908, 150, true);


		authorservice.save(author1);
		authorservice.save(author2);
		authorservice.save(author3);
		authorservice.save(author4);
		authorservice.save(author6);




		logger.info("count: " + authorservice.count());
		logger.info(authorservice.findAll());
		logger.info("exists ['2']: " + authorservice.existsById("2"));


		authorservice.findAndDeleteById("3");

		logger.info("count: " + authorservice.count());
		logger.info(authorservice.findAll());
		logger.info("exists ['2']: " + authorservice.existsById("2"));

		authorservice.save(new Author("5", "Ken Follet","Gales", 1949, 300, false));


		logger.info("count: " + authorservice.count());
		logger.info(authorservice.findAll());
		logger.info("exists ['2']: " + authorservice.existsById("2"));
		logger.info("exists ['5']: " + authorservice.existsById("5"));

		author3.setName("LLuis");
		logger.info("count: " + authorservice.count());
		authorservice.update("2", author3);
		logger.info(authorservice.findAll());








	}

}
