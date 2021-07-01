package com.worstMovieApp.apirest.controller;

import com.worstMovieApp.apirest.model.dto.ProducerInterval;
import com.worstMovieApp.apirest.model.dto.ProducerIntervals;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class LongestProducerInterval {

    private static final String MAX_INTERVAL = "max";
    private static final String MIN_INTERVAL = "min";

    private Map<Integer, List<ProducerInterval>> producerMostIntervalsMap = new TreeMap<>(Collections.reverseOrder());
    private Map<Integer, List<ProducerInterval>> producerMinIntervalsMap = new TreeMap<>();

    public ProducerIntervals converter(Map<String, List<Integer[]>> producerPairsAwards) {

        producerPairsAwards.forEach((producerAux, pairs) -> {
            addIntervals(MAX_INTERVAL, producerAux, pairs);
            addIntervals(MIN_INTERVAL, producerAux, pairs);
        });
        return ProducerIntervals.builder()
                .maxIntervalList(producerMostIntervalsMap.get(producerMostIntervalsMap.keySet().stream().findFirst().get()))
                .minIntervalList(producerMinIntervalsMap.get(producerMinIntervalsMap.keySet().stream().findFirst().get()))
                .build();
    }

    private void addIntervals(String type, String producerAux, List<Integer[]> pairs) {
        AtomicReference<String> producer = new AtomicReference<>();
        AtomicReference<Integer> previousWin = new AtomicReference<>();
        AtomicReference<Integer> followingWin = new AtomicReference<>();
        AtomicReference<Integer> interval = new AtomicReference<>(0);
        for (Integer[] pair : pairs) {
            Integer following = pair[1];
            Integer previous = pair[0];
            Integer intervalAux = following - previous;
            if (type.equals(MAX_INTERVAL)) {
                if (intervalAux >= interval.get()) {
                    interval.set(intervalAux);
                    producer.set(producerAux);
                    previousWin.set(previous);
                    followingWin.set(following);
                }
            } else {
                if(interval.get() == 0) {
                    interval.set(intervalAux);
                }
                if (intervalAux <= interval.get()) {
                    interval.set(intervalAux);
                    producer.set(producerAux);
                    previousWin.set(previous);
                    followingWin.set(following);
                }
            }
        }
        addToMap(type, interval.get(), ProducerInterval.builder()
                .producer(producerAux)
                .previousWin(previousWin.get())
                .followingWin(followingWin.get())
                .interval(interval.get())
                .build());
    }


    private void addToMap(String type, Integer interval, ProducerInterval producerInterval) {
        if (type.equals(MAX_INTERVAL)) {
            List<ProducerInterval> list = producerMostIntervalsMap.getOrDefault(interval, new ArrayList<>());
            list.add(producerInterval);
            producerMostIntervalsMap.put(interval, list);
        } else if (type.equals(MIN_INTERVAL)){
            List<ProducerInterval> list = producerMinIntervalsMap.getOrDefault(interval, new ArrayList<>());
            list.add(producerInterval);
            producerMinIntervalsMap.put(interval, list);
        }
    }
}
