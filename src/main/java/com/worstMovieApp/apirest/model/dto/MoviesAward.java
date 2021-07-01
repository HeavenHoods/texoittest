package com.worstMovieApp.apirest.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MoviesAward {
    private Long year;
    private String title;
    private String studios;
    private String producers;
    private String winner;
}
