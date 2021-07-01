package com.worstMovieApp.apirest;

import com.worstMovieApp.apirest.model.entity.Movie;
import com.worstMovieApp.apirest.services.MoviePopulateService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApirestApplicationTests {

	private static final String HOST = "http://localhost:";
	private static final String BASE_PATH = "/api/gra/movies";

	@LocalServerPort
	private int port;

	@Autowired
	private MoviePopulateService moviePopulateService;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	void setup(){
		moviePopulateService.createData();
	}

	@Test
	void contextLoadsAwardInterval() {
		Movie movie = getMovie();
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(HOST + port + BASE_PATH + "/producer/intervalbetweenawards", String.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	private Movie getMovie() {
		Movie movie = new Movie();
		movie.setYear(1981);
		movie.setTitle("Mommie Dearest");
		movie.setStudios("Paramount Pictures");
		movie.setProducers("Frank Yablans");
		movie.setWinner("yes");
		return movie;
	}

}
