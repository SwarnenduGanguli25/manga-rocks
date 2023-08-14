package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.db.CategoryDataSevice;
import com.manga.application.mangarocks.dto.CategoryDTO;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.ResultResponse;
import com.manga.application.mangarocks.exceptions.ValidationException;
import com.manga.application.mangarocks.utils.ValidationUtil;
import com.manga.application.mangarocks.validation.CategoryCreateRequestValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDataSevice categoryDataSevice;

    @Override
    public GenericResponse createCategory(CategoryDTO categoryDTO) {
        if (Objects.isNull(categoryDTO)) {
            throw new ValidationException("Category Block received is null");
        }
        ValidationUtil.validate(categoryDTO, CategoryCreateRequestValidation.class);
        categoryDataSevice.save(categoryDTO.getMangaCategoryName(), categoryDTO.getCategoryDescription());
        return GenericResponse.builder().successResponse(new ResultResponse("New Category added Successfully")).build();
    }
}
