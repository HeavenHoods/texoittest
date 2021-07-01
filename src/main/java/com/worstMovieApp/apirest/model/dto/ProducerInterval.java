package com.worstMovieApp.apirest.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProducerInterval {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;
}
