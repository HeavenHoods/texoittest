package com.worstMovieApp.apirest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.worstMovieApp.apirest.services.CSVReaderService;
import com.worstMovieApp.apirest.services.MoviePopulateService;

@SpringBootApplication
public class ApirestApplication implements ApplicationRunner {

private static final Logger LOGGER = LoggerFactory.getLogger(ApirestApplication.class);

	@Autowired
	private CSVReaderService csvReaderService;

	@Autowired
	private MoviePopulateService moviePopulateService;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		moviePopulateService.createData();
	}

}
