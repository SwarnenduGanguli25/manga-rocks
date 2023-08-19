package com.manga.application.mangarocks.db;

import com.manga.application.mangarocks.model.Category;

import java.util.List;

public interface CategoryDataSevice {
    void save(final String categoryName, final String categoryDescription);

    Category findByCategory(final String categoryName);

    List<Category> getAllCategories();
}
