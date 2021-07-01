package com.worstMovieApp.apirest.services;


import com.worstMovieApp.apirest.model.entity.Movie;
import com.worstMovieApp.apirest.repository.RepositoryFromMovies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final String WINNER_YES = "yes";

    private final RepositoryFromMovies repository;

    public MovieService(RepositoryFromMovies repository) {
        this.repository = repository;
    }

    public void saveAll(List<Movie> movies) {
        repository.saveAll(movies);
    }

    public List<Movie> getAll(){
        return repository.findAll();
    }

    public List<Movie> getAllWinners(){
        return repository.findAllByWinnerEquals(WINNER_YES);
    }
}
