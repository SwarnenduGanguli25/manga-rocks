package com.manga.application.mangarocks.db;

import com.manga.application.mangarocks.model.Category;
import com.manga.application.mangarocks.repo.CategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryDataServiceImpl implements CategoryDataSevice {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category save(String categoryName, String categoryDescription) {
        Category category = Category.builder().
                categoryName(categoryName).
                categoryDescription(categoryDescription).build();
        categoryRepo.save(category);
        log.info("New Category has been saved.");
        return category;
    }
}
