package com.worstMovieApp.apirest.repository;

import com.worstMovieApp.apirest.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryFromMovies extends JpaRepository<Movie, Long> {

    public List<Movie> findAllByWinnerEquals(String condition);

}
