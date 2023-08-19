package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.db.CategoryDataSevice;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.ResultResponse;
import com.manga.application.mangarocks.exceptions.ValidationException;
import com.manga.application.mangarocks.model.Category;
import com.manga.application.mangarocks.utils.ResponseBuilder;
import com.manga.application.mangarocks.utils.ValidationUtil;
import com.manga.application.mangarocks.validation.CategoryCreateRequestValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDataSevice categoryDataSevice;
    @Autowired
    private ResponseBuilder responseBuilder;

    @Override
    public ResponseEntity<GenericResponse> createCategory(CategoryDTO categoryDTO) {
        ValidationUtil.validate(categoryDTO, CategoryCreateRequestValidation.class);
        Category category = categoryDataSevice.findByCategory(categoryDTO.getMangaCategoryName());
        if (Objects.nonNull(category)) {
            log.info("Duplicate Request with same Category name received");
            return responseBuilder.getSuccessResponse("Category with this name already exists", HttpStatus.OK);
        }
        categoryDataSevice.save(categoryDTO.getMangaCategoryName(), categoryDTO.getCategoryDescription());
        return responseBuilder.getSuccessResponse("New Category added Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GenericResponse> getAllCategory() {
        List<Category> categoryList = categoryDataSevice.getAllCategories();
        return new ResponseEntity<>(GenericResponse.builder().successResponse(categoryList).build(), HttpStatus.OK);
    }
}
