package com.mozen.springbootpaginatedsearch;

import com.mozen.springbootpaginatedsearch.repository.SearchRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = SearchRepositoryImpl.class)
public class ApplicationConfiguration {
}
