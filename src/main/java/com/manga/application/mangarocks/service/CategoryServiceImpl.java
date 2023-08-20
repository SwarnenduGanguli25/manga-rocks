package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.db.CategoryDataSevice;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.exceptions.InvalidIdException;
import com.manga.application.mangarocks.exceptions.ValidationException;
import com.manga.application.mangarocks.model.Category;
import com.manga.application.mangarocks.utils.ResponseBuilder;
import com.manga.application.mangarocks.utils.ValidationUtil;
import com.manga.application.mangarocks.validation.CategoryCreateRequestValidation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
            return responseBuilder.getSuccessResponse("Category with this name already exists!!", HttpStatus.OK);
        }
        categoryDataSevice.save(categoryDTO.getMangaCategoryName(), categoryDTO.getCategoryDescription());
        return responseBuilder.getSuccessResponse("New Category added Successfully!!", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GenericResponse> getAllCategory() {
        List<Category> categoryList = categoryDataSevice.getAllCategories();
        return responseBuilder.getSuccessResponse(categoryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getCategoryById(Long id) {
        Optional<Category> category = categoryDataSevice.findById(id);
        if (category.isEmpty())
            throw new InvalidIdException("No Category with this Id exists!!");
        else
            return responseBuilder.getSuccessResponse(category.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getCategoryByName(String name) {
        Category category = categoryDataSevice.findByCategory(name);
        if (Objects.isNull(category))
            throw new InvalidIdException("No Category with this Name Exists!!");
        else
            return responseBuilder.getSuccessResponse(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> updateCategoryById(Long id, CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryDataSevice.findById(id);
        if (optionalCategory.isEmpty())
            throw new InvalidIdException("No Category with this Id exists!!");
        else {
            Category category = optionalCategory.get();
            if (Strings.isBlank(categoryDTO.getMangaCategoryName()) && Strings.isBlank(categoryDTO.getCategoryDescription()))
                throw new ValidationException("No updates were made. Please provide valid inputs for updating");
            else if (Strings.isBlank(categoryDTO.getMangaCategoryName())) {
                category.setCategoryDescription(categoryDTO.getCategoryDescription());
            } else if (Strings.isBlank(categoryDTO.getCategoryDescription())) {
                category.setCategoryName(categoryDTO.getMangaCategoryName());
            } else {
                category.setCategoryName(categoryDTO.getMangaCategoryName());
                category.setCategoryDescription(categoryDTO.getCategoryDescription());
            }
            categoryDataSevice.updateCategory(category);
        }
        return responseBuilder.getSuccessResponse("Category has been successfully updated!!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> updateCategoryByName(String name, CategoryDTO categoryDTO) {
        Category category = categoryDataSevice.findByCategory(name);
        if (Objects.isNull(category))
            throw new InvalidIdException("No Category with this Name Exists!!");
        else {
            if (Strings.isBlank(categoryDTO.getMangaCategoryName()) && Strings.isBlank(categoryDTO.getCategoryDescription()))
                throw new ValidationException("No updates were made. Please provide valid inputs for updating");
            else if (Strings.isBlank(categoryDTO.getMangaCategoryName())) {
                category.setCategoryDescription(categoryDTO.getCategoryDescription());
            } else if (Strings.isBlank(categoryDTO.getCategoryDescription())) {
                category.setCategoryName(categoryDTO.getMangaCategoryName());
            } else {
                category.setCategoryName(categoryDTO.getMangaCategoryName());
                category.setCategoryDescription(categoryDTO.getCategoryDescription());
            }
            categoryDataSevice.updateCategory(category);
        }
        return responseBuilder.getSuccessResponse("Category has been successfully updated!!", HttpStatus.OK);
    }
}
