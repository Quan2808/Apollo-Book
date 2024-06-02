package com.apollo.bookstore.library.services.impl;

import com.apollo.bookstore.library.dto.CategoryDto;
import com.apollo.bookstore.library.entities.Category;
import com.apollo.bookstore.library.repositories.CategoryRepository;
import com.apollo.bookstore.library.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        Category categorySave = new Category();
        categorySave.setName(category.getName());
        categorySave.setActivated(true);
        categorySave.setDeleted(false);
        return categoryRepository.save(categorySave);
    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = categoryRepository.getReferenceById(category.getId());
        categoryUpdate.setName(category.getName());
        return categoryRepository.save(categoryUpdate);
    }

    @Override
    public List<Category> findAllByActivatedTrue() {
        return categoryRepository.findAllByActivatedTrue();
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setActivated(true);
            category.setDeleted(false);
            categoryRepository.save(category);
        }
    }

    @Override
    public void enableById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setActivated(true);
            category.setDeleted(false);
            categoryRepository.save(category);
        }
    }

    @Override
    public List<CategoryDto> getCategoriesAndSize() {
        List<CategoryDto> categories = categoryRepository.getCategoriesAndSize();
        return categories;
    }

}
