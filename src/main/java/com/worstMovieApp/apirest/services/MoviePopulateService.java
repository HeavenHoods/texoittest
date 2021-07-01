package com.worstMovieApp.apirest.services;

import com.worstMovieApp.apirest.controller.MovieSetter;
import com.worstMovieApp.apirest.model.dto.MoviesAward;
import com.worstMovieApp.apirest.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoviePopulateService {

    private final CSVReaderService csvReaderService;
    private final MovieService movieService;

    public MoviePopulateService(CSVReaderService csvReaderService, MovieService movieService) {
        this.csvReaderService = csvReaderService;
        this.movieService = movieService;
    }

    public void createData() {
        List<Movie> movies = csvReaderService.loadObjectList(MoviesAward.class).stream().map(new MovieSetter()).collect(Collectors.toList());
        movieService.saveAll(movies);
    }

}
