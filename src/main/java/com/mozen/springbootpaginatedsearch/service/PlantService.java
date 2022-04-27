package com.mozen.springbootpaginatedsearch.service;

import com.mozen.springbootpaginatedsearch.model.PageDTO;
import com.mozen.springbootpaginatedsearch.model.Plant;
import com.mozen.springbootpaginatedsearch.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlantService {

    private PlantRepository plantRepository;

    private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("name","scientificName","family");

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> searchPlants(String text, List<String> fields, int limit) {

        List<String> fieldsToSearchBy = getFieldsToSearchBy(fields);

        return plantRepository.searchBy(
                text, limit, fieldsToSearchBy.toArray(new String[0]));
    }

    public PageDTO<Plant> searchPlantPage(String text, List<String> fields, int limit, int pageOffset) {
        List<String> fieldsToSearchBy = getFieldsToSearchBy(fields);

        return plantRepository.searchPageBy(
                text, limit, pageOffset, fieldsToSearchBy.toArray(new String[0]));
    }

    private List<String> getFieldsToSearchBy(List<String> fields) {
        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;

        boolean containsInvalidField = fieldsToSearchBy.stream(). anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));

        if(containsInvalidField) {
            throw new IllegalArgumentException();
        }
        return fieldsToSearchBy;
    }
}
