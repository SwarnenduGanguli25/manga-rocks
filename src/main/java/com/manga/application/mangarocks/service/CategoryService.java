package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;

public interface CategoryService {
    GenericResponse createCategory(CategoryDTO categoryDTO);
}
