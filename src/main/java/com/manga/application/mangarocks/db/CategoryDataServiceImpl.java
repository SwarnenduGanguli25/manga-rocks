package com.manga.application.mangarocks.db;

import com.manga.application.mangarocks.model.Category;
import com.manga.application.mangarocks.repo.CategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryDataServiceImpl implements CategoryDataSevice {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void save(String categoryName, String categoryDescription) {
        Category category = Category.builder().
                categoryName(categoryName).
                categoryDescription(categoryDescription).build();
        categoryRepo.save(category);
        log.info("New Category has been saved.");
    }

    @Override
    public Category findByCategory(String categoryName) {
        return categoryRepo.findByCategoryName(categoryName);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
