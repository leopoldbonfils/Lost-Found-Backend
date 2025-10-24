package com.Lost.FoundBackend.Lost.FoundBackend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.Lost.FoundBackend.Lost.FoundBackend.model.ItemCategory;

import com.Lost.FoundBackend.Lost.FoundBackend.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    // Save category
    public String saveCategory(ItemCategory category){
        if(categoryRepository.existsByName(category.getName())){
            return "Category already exists";
        } else {
            categoryRepository.save(category);
            return "Category saved successfully";
        }
    }

    // Get all categories
    public List<ItemCategory> getAllCategories(){
        return categoryRepository.findAll();
    }

    // Get category by ID
    public Optional<ItemCategory> getCategoryById(UUID id){
        return categoryRepository.findById(id);
    }

    // Search categories by name
    public List<ItemCategory> searchByName(String name){
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    // Update category
    public String updateCategory(ItemCategory category){
        if(categoryRepository.existsById(category.getId())){
            categoryRepository.save(category);
            return "Category updated successfully";
        } else {
            return "Category not found";
        }
    }

    // Delete category
    public String deleteCategory(UUID id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return "Category deleted successfully";
        } else {
            return "Category not found";
        }
    }
}
