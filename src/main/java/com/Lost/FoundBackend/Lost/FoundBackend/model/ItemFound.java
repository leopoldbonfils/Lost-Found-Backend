package com.Lost.FoundBackend.Lost.FoundBackend.model;

import java.time.LocalDate;
import java.util.UUID;

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

@Entity
@Table(name = "foundItems")
public class ItemFound {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "dateFound")
    private LocalDate dateFound;
    @Column (name = "color")
    private String color;
    
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    
    @ManyToOne
    @JoinColumn(name = "found_by")
    private User foundBy;

    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getFoundBy() {
        return foundBy;
    }

    public void setFoundBy(User foundBy) {
        this.foundBy = foundBy;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    
}
