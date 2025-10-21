package com.Lost.FoundBackend.Lost.FoundBackend.service;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lost.FoundBackend.Lost.FoundBackend.model.ItemFound;
import com.Lost.FoundBackend.Lost.FoundBackend.repository.ItemFoundRepository;

@Service
public class ItemFoundService {

    @Autowired
    private ItemFoundRepository itemFoundRepository;

    // Save found item
    public String saveFoundItem(ItemFound itemFound){
        if(itemFoundRepository.existsByNameAndFoundBy_Id(itemFound.getName(), itemFound.getFoundBy().getId())){
            return "Item already exists";
        } else {
            itemFoundRepository.save(itemFound);
            return "Saved successfully";
        }
    }

    // Get all found items
    public List<ItemFound> getAllFoundItems(){
        return itemFoundRepository.findAll();
    }

    // Get found item by ID
    public Optional<ItemFound> getFoundItemById(UUID id){
        return itemFoundRepository.findById(id);
    }

    // Search found items by name
    public List<ItemFound> searchByName(String name){
        return itemFoundRepository.findByNameContainingIgnoreCase(name);
    }

    // Search found items by category
    public List<ItemFound> searchByCategory(String categoryName){
        return itemFoundRepository.findByCategory_Name(categoryName);
    }

    // Update found item
    public String updateFoundItem(ItemFound itemFound){
        if(itemFoundRepository.existsById(itemFound.getId())){
            itemFoundRepository.save(itemFound);
            return "Updated successfully";
        } else {
            return "Found item not found";
        }
    }

    // Delete found item
    public String deleteFoundItem(UUID id){
        if(itemFoundRepository.existsById(id)){
            itemFoundRepository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Found item not found";
        }
    }
}
