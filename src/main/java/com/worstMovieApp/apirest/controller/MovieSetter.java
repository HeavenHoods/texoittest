package com.worstMovieApp.apirest.controller;

import com.worstMovieApp.apirest.model.dto.MoviesAward;
import com.worstMovieApp.apirest.model.entity.Movie;
import java.util.function.Function;

public class MovieSetter implements Function<MoviesAward, Movie> {

    @Override
    public Movie apply(MoviesAward dto) {
        Movie movie = new Movie();
        movie.setYear(dto.getYear().intValue());
        movie.setTitle(dto.getTitle());
        movie.setStudios(dto.getStudios());
        movie.setProducers(dto.getProducers());
        movie.setWinner(dto.getWinner());
        return movie;
    }
}
