package com.Lost.FoundBackend.Lost.FoundBackend.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.http.MediaType;
import java.util.List;
import java.util.Optional;


import com.Lost.FoundBackend.Lost.FoundBackend.model.LostItem;
import com.Lost.FoundBackend.Lost.FoundBackend.service.LostItemService;

@RestController
@RequestMapping(value = "/api/lostItem")
public class LostItemController {

    @Autowired
    private LostItemService lostItemService;

    // ✅ Save Lost Item
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveLostItem(@RequestBody LostItem lostItem) {
        String response = lostItemService.saveLostItem(lostItem);

        if (response.equalsIgnoreCase("Lost item already exists for this user")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    // ✅ Get All Lost Items
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LostItem>> getAllLostItems() {
        return new ResponseEntity<>(lostItemService.getAllLostItems(), HttpStatus.OK);
    }

    // ✅ Get Lost Item by ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLostItemById(@PathVariable("id") UUID id) {
        Optional<LostItem> lostItem = lostItemService.getLostItemById(id);

        if (lostItem.isPresent()) {
            return new ResponseEntity<>(lostItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Lost item not found", HttpStatus.NOT_FOUND);
        }
    }
    

    // ✅ Search Lost Items by Name
    @GetMapping(value = "/search/by-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        List<LostItem> items = lostItemService.searchByName(name);

        if (items.isEmpty()) {
            return new ResponseEntity<>("No lost items found with this name", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
    }

    // ✅ Search Lost Items by Category
    @GetMapping(value = "/search/by-category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByCategory(@RequestParam String category) {
        List<LostItem> items = lostItemService.searchByCategory(category);

        if (items.isEmpty()) {
            return new ResponseEntity<>("No lost items found in this category", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
    }

    // ✅ Update Lost Item
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateLostItem(@RequestBody LostItem lostItem) {
        String response = lostItemService.updateLostItem(lostItem);

        if (response.equalsIgnoreCase("Lost item not found")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    // ✅ Delete Lost Item
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteLostItem(@PathVariable("id") UUID id) {
        String response = lostItemService.deleteLostItem(id);

        if (response.equalsIgnoreCase("Lost item not found")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    
}
