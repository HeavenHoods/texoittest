package com.worstMovieApp.apirest.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.worstMovieApp.apirest.ApirestApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
public class CSVReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApirestApplication.class);
    private final String FILE_NAME = "movielist.csv";


    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        LOGGER.info("Creating data");
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            LOGGER.info("Data has been created");
            return readValues.readAll();
        } catch (Exception e) {
            LOGGER.error("Error when creating data");
            return Collections.emptyList();
        }
    }

    public <T> List<T> loadObjectList(Class<T> type) {
        return loadObjectList(type, FILE_NAME);
    }

}
