package com.worstMovieApp.apirest.services;

import com.worstMovieApp.apirest.controller.LongestProducerInterval;
import com.worstMovieApp.apirest.model.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProducerService {

    private Map<String, Set<Integer>> producersWinners;
    private Map<String, Set<Integer>> producerMoreThanOneAward;

    private void createProducerMovieWinners(List<Movie> movies) {
        List<Movie> winners = movies.stream().filter(movie -> movie.getWinner().equals("yes")).collect(Collectors.toList());
        producersWinners = new HashMap<>(0);
        producerMoreThanOneAward = new HashMap<>(0);
        for (Movie winner : winners) {
            if(winner.getProducers().contains(" and ")){
                winner.setProducers(winner.getProducers().trim().replaceAll(" and ", ",").replaceAll(", ",","));
                List<String> producers = Arrays.stream(winner.getProducers().split(",")).collect(Collectors.toList());
                producers.forEach(producer -> addProducerAwards(winner.getYear(), producer));
            } else {
                addProducerAwards(winner.getYear(), winner.getProducers());
            }
        }
    }

    private void addProducerAwards(Integer year, String producer) {
        if (!producersWinners.containsKey(producer)) {
            Set<Integer> years = new TreeSet<>();
            years.add(year);
            producersWinners.put(producer, years);
        } else {
            producersWinners.get(producer).add(year);
            producerMoreThanOneAward.put(producer, producersWinners.get(producer));
        }
    }

    public Object getAwardIntervals(List<Movie> movies){
        createProducerMovieWinners(movies);
        Map<String, List<Integer[]>> producePairs = new HashMap<>(0);
        producerMoreThanOneAward.forEach((producer, years) -> {
            producePairs.put(producer, new ArrayList<>());
            List<Integer> yearsAux = new ArrayList<>(years);
            for (int i = 0; i < years.size(); i++) {
                if(i + 1 != years.size()) {
                    Integer[] pair = {yearsAux.get(i), yearsAux.get(i + 1)};
                    producePairs.get(producer).add(pair);
                }
            }
        });
        return new LongestProducerInterval().converter(producePairs);
    }
}
