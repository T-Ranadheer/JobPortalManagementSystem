package com.jobportal.controller;

import com.jobportal.entity.Category;
import com.jobportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {

        model.addAttribute("categories",
                categoryService.getAllCategories());

        model.addAttribute("category",
                new Category());

        return "categories";
    }

    @PostMapping("/save")
    public String saveCategory(
            @ModelAttribute Category category) {

        categoryService.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(
            @PathVariable Long id) {

        categoryService.delete(id);

        return "redirect:/categories";
    }

}