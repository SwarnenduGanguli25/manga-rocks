package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CategoryController {

    @RequestMapping(value = "/category/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    ResponseEntity<GenericResponse> createMangaCategory(@RequestBody CategoryDTO categoryDTO) throws JsonProcessingException;

    @RequestMapping(value = "/category/getAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<GenericResponse> getAllMangaCategory();

    @RequestMapping(value = "/category/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<GenericResponse> getMangaCategoryById(@PathVariable("id") Long id);

    @RequestMapping(value = "/category/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<GenericResponse> getMangaCategoryByIdParam(@RequestParam("id") Long id);

    @RequestMapping(value = "/category/getByName", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<GenericResponse> getMangaCategoryByName(@RequestParam("name") String name);

    @RequestMapping(value = "/category/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    ResponseEntity<GenericResponse> updateMangaCategoryById(@PathVariable("id") Long id, @RequestBody CategoryDTO categoryDTO);
}
