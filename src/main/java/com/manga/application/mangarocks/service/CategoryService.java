package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<GenericResponse> createCategory(CategoryDTO categoryDTO);

    ResponseEntity<GenericResponse> getAllCategory();

    ResponseEntity<GenericResponse> getCategoryById(Long id);

    ResponseEntity<GenericResponse> getCategoryByName(String name);

    ResponseEntity<GenericResponse> updateCategoryById(Long id, CategoryDTO categoryDTO);

    ResponseEntity<GenericResponse> updateCategoryByName(String name, CategoryDTO categoryDTO);
}
