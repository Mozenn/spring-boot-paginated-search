package com.mozen.springbootpaginatedsearch.repository;

import com.mozen.springbootpaginatedsearch.model.PageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface SearchRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> searchBy(String text, int limit, String... fields);

    PageDTO<T> searchPageBy(String text, int limit, int offset, String... fields);
}
