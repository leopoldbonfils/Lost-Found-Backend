package com.Lost.FoundBackend.Lost.FoundBackend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.Lost.FoundBackend.Lost.FoundBackend.repository.LostItemRepository;


import com.Lost.FoundBackend.Lost.FoundBackend.model.LostItem;

@Service
public class LostItemService {
    @Autowired
    private LostItemRepository lostItemRepository;

    // Save lost item
    public String saveLostItem(LostItem lostItem) {
        if (lostItemRepository.existsByNameAndReportedBy(lostItem.getName(), lostItem.getReportedBy())) {
            return "Lost item already exists for this user";
        } else {
            // Set default status if not provided
            if (lostItem.getStatus() == null || lostItem.getStatus().isEmpty()) {
                lostItem.setStatus("LOST");
            }
            lostItemRepository.save(lostItem);
            return "Lost item saved successfully";
        }
    }

    // Get all lost items
    public List<LostItem> getAllLostItems(){
        return lostItemRepository.findAll();
    }

    // Get lost item by ID
    public Optional<LostItem> getLostItemById(UUID id){
        return lostItemRepository.findById(id);
    }

    // Search lost items by name
    public List<LostItem> searchByName(String name){
        return lostItemRepository.findByNameContainingIgnoreCase(name);
    }

    // Search lost items by category
    public List<LostItem> searchByCategory(String categoryName){
        return lostItemRepository.findByCategory_Name(categoryName);
    }

    // Update lost item
    public String updateLostItem(LostItem lostItem){
        if(lostItemRepository.existsById(lostItem.getId())){
            lostItemRepository.save(lostItem);
            return "Lost item updated successfully";
        } else {
            return "Lost item not found";
        }
    }

    // Delete lost item
    public String deleteLostItem(UUID id){
        if(lostItemRepository.existsById(id)){
            lostItemRepository.deleteById(id);
            return "Lost item deleted successfully";
        } else {
            return "Lost item not found";
        }
    }
}
