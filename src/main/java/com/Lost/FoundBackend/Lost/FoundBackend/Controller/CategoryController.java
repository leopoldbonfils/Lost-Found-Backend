package com.Lost.FoundBackend.Lost.FoundBackend.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import com.Lost.FoundBackend.Lost.FoundBackend.model.Category;

import com.Lost.FoundBackend.Lost.FoundBackend.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // ✅ Create new category
    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody Category category) {
        String message = categoryService.saveCategory(category);
        return ResponseEntity.ok(message);
    }

    // ✅ Get all categories
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // ✅ Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable UUID id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.status(404).body("Category not found");
        }
    }

    // ✅ Search category by name
    @GetMapping("/search")
    public ResponseEntity<List<Category>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(categoryService.searchByName(name));
    }

    // ✅ Update category
    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody Category category) {
        String message = categoryService.updateCategory(category);
        return ResponseEntity.ok(message);
    }

    // ✅ Delete category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable UUID id) {
        String message = categoryService.deleteCategory(id);
        return ResponseEntity.ok(message);
    }
    
}
