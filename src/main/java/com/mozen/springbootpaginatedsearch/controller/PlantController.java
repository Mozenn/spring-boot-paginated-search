package com.mozen.springbootpaginatedsearch.controller;

import com.mozen.springbootpaginatedsearch.model.PageDTO;
import com.mozen.springbootpaginatedsearch.model.PageableSearchRequestDTO;
import com.mozen.springbootpaginatedsearch.model.Plant;
import com.mozen.springbootpaginatedsearch.model.SearchRequestDTO;
import com.mozen.springbootpaginatedsearch.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/plant")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/search")
    public List<Plant> searchPlants(SearchRequestDTO searchRequestDTO) {

        log.info("Request for plant search received with data : " + searchRequestDTO);

        return plantService.searchPlants(searchRequestDTO.getText(), searchRequestDTO.getFields(), searchRequestDTO.getLimit());
    }

    @GetMapping("/search/page")
    public PageDTO<Plant> searchPlantPage(PageableSearchRequestDTO pageableSearchRequestDTO) {

        log.info("Request for plant page search received with data : " + pageableSearchRequestDTO);

        return plantService.searchPlantPage(pageableSearchRequestDTO.getText(), pageableSearchRequestDTO.getFields(), pageableSearchRequestDTO.getLimit(), pageableSearchRequestDTO.getPageOffset());
    }
}
