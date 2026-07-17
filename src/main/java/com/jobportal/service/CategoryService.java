package com.jobportal.service;

import com.jobportal.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    void delete(Long id);

}