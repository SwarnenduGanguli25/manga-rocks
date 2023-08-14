package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CategoryController {

    @RequestMapping(value = "/category/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    GenericResponse createMangaCategory(@RequestBody CategoryDTO categoryDTO) throws JsonProcessingException;
}