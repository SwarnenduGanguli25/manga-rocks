package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.utils.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manga/v1")
@Slf4j
public class Controller implements CategoryController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public GenericResponse createMangaCategory(CategoryDTO categoryDTO) throws JsonProcessingException {
        log.info("Create Manga Category Request {}", JsonParser.objectToJson(objectMapper.writeValueAsString(categoryDTO)));
        return null;
    }
}
