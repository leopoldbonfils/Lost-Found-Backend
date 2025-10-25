package com.Lost.FoundBackend.Lost.FoundBackend.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "found_items")
public class ItemFound {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "date_found")
    private LocalDate dateFound;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "status")
    private String status;  // FOUND, RETURNED, UNCLAIMED
    
    @ManyToOne
    @JoinColumn(name = "foundBy_id")
    private User foundBy;

    @ManyToOne
    @JoinColumn(name = "locationFound_id")
    private Location locationFound;

    @OneToOne
    @JoinColumn(name = "lost_item_id")
    private LostItem lostItem;

    @ManyToOne
    @JoinColumn(name = "item_category_id") 
    private ItemCategory itemCategory;

    public ItemFound() {
    }

   
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateFound() {
        return dateFound;
    }

    public void setDateFound(LocalDate dateFound) {
        this.dateFound = dateFound;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getFoundBy() {
        return foundBy;
    }

    public void setFoundBy(User foundBy) {
        this.foundBy = foundBy;
    }

    public Location getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(Location locationFound) {
        this.locationFound = locationFound;
    }

    public LostItem getLostItem() {
        return lostItem;
    }

    public void setLostItem(LostItem lostItem) {
        this.lostItem = lostItem;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}