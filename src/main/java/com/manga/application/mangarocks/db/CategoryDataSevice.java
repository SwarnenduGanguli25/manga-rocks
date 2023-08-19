package com.manga.application.mangarocks.db;

import com.manga.application.mangarocks.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDataSevice {
    void save(final String categoryName, final String categoryDescription);

    Category findByCategory(final String categoryName);

    List<Category> getAllCategories();

    Optional<Category> findById(long id);
}
