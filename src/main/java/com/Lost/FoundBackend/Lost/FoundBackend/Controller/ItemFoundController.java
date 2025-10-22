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


import com.Lost.FoundBackend.Lost.FoundBackend.model.ItemFound;
import com.Lost.FoundBackend.Lost.FoundBackend.service.ItemFoundService;


@RestController
@RequestMapping("/api/itemFound")
public class ItemFoundController {

    @Autowired
    private ItemFoundService itemFoundService;

    // ✅ Save a found item
    @PostMapping("/save")
    public ResponseEntity<String> saveFoundItem(@RequestBody ItemFound itemFound) {
        String message = itemFoundService.saveFoundItem(itemFound);
        return ResponseEntity.ok(message);
    }

    // ✅ Get all found items
    @GetMapping("/all")
    public ResponseEntity<List<ItemFound>> getAllFoundItems() {
        return ResponseEntity.ok(itemFoundService.getAllFoundItems());
    }

    // ✅ Get found item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFoundItemById(@PathVariable UUID id) {
        Optional<ItemFound> foundItem = itemFoundService.getFoundItemById(id);
        if (foundItem.isPresent()) {
            return ResponseEntity.ok(foundItem.get());
        } else {
            return ResponseEntity.status(404).body("Item not found");
        }
    }

    // ✅ Search by name
    @GetMapping("/search/name")
    public ResponseEntity<List<ItemFound>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(itemFoundService.searchByName(name));
    }

    // ✅ Search by category
    @GetMapping("/search/category")
    public ResponseEntity<List<ItemFound>> searchByCategory(@RequestParam String categoryName) {
        return ResponseEntity.ok(itemFoundService.searchByCategory(categoryName));
    }

    // ✅ Update found item
    @PutMapping("/update")
    public ResponseEntity<String> updateFoundItem(@RequestBody ItemFound itemFound) {
        String message = itemFoundService.updateFoundItem(itemFound);
        return ResponseEntity.ok(message);
    }

    // ✅ Delete found item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFoundItem(@PathVariable UUID id) {
        String message = itemFoundService.deleteFoundItem(id);
        return ResponseEntity.ok(message);
    }
    
}
