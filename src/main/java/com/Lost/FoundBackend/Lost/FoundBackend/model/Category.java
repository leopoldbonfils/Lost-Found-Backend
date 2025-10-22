package com.Lost.FoundBackend.Lost.FoundBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "categoryType")
    private String CategoryType;

    
    @OneToMany(mappedBy = "category")
    private List<LostItem> lostItems;

   
    @OneToMany(mappedBy = "category")
    private List<ItemFound> foundItems;

    public Category() {

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

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String categoryType) {
        CategoryType = categoryType;
    }

    public List<LostItem> getLostItems() {
        return lostItems;
    }

    public void setLostItems(List<LostItem> lostItems) {
        this.lostItems = lostItems;
    }

    public List<ItemFound> getFoundItems() {
        return foundItems;
    }

    public void setFoundItems(List<ItemFound> foundItems) {
        this.foundItems = foundItems;
    }

    

    
    
}
