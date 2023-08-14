package com.manga.application.mangarocks.db;

import com.manga.application.mangarocks.model.Category;

public interface CategoryDataSevice {
    Category save(final String categoryName, final String categoryDescription);
}
