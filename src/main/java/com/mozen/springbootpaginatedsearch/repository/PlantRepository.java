package com.mozen.springbootpaginatedsearch.repository;

import com.mozen.springbootpaginatedsearch.model.Plant;
import org.springframework.stereotype.Repository;


@Repository
public interface PlantRepository extends SearchRepository<Plant, Long> {
}
