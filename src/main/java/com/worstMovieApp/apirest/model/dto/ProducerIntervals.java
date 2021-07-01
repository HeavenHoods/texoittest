package com.worstMovieApp.apirest.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ProducerIntervals {
    @JsonProperty("min")
    private List<ProducerInterval> minIntervalList;

    @JsonProperty("max")
    private List<ProducerInterval> maxIntervalList;
}
