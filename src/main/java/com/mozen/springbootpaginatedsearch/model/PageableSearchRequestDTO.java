package com.mozen.springbootpaginatedsearch.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageableSearchRequestDTO extends SearchRequestDTO{

    @Min(0)
    private int pageOffset;
}
