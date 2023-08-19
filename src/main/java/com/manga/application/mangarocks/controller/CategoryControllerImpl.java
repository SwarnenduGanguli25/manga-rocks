package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.service.CategoryService;
import com.manga.application.mangarocks.utils.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manga/v1")
@Slf4j
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseEntity<GenericResponse> createMangaCategory(CategoryDTO categoryDTO) throws JsonProcessingException {
        log.info("Create Manga Category Request {}", JsonParser.objectToJson(objectMapper.writeValueAsString(categoryDTO)));
        return categoryService.createCategory(categoryDTO);
    }

    @Override
    public ResponseEntity<GenericResponse> getAllMangaCategory() {
        log.info("Fetching all Categories list.");
        return categoryService.getAllCategory();
    }
}
