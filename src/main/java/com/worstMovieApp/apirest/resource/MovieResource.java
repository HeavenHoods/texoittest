package com.worstMovieApp.apirest.resource;

import com.worstMovieApp.apirest.model.entity.Movie;
import com.worstMovieApp.apirest.services.MovieService;
import com.worstMovieApp.apirest.services.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/gra/movies")
public class MovieResource {

    private final MovieService movieService;
    private final ProducerService producerService;

    public MovieResource(MovieService movieService, ProducerService producerService) {
        this.movieService = movieService;
        this.producerService = producerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/all/winners")
    public ResponseEntity<List<Movie>> getAllWinners(){
        return ResponseEntity.ok(movieService.getAllWinners());
    }

    @GetMapping("/producer/intervalbetweenawards")
    public ResponseEntity<Object> getAwardIntervals(){
        return ResponseEntity.ok(producerService.getAwardIntervals(movieService.getAllWinners()));
    }

    @GetMapping("/test/run")
    public ResponseEntity<Object> runTest(){

        return null;
    }

}
