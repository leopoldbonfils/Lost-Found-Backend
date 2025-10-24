package com.Lost.FoundBackend.Lost.FoundBackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "lost_items")
public class LostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "date_lost")
    private LocalDate dateLost;
    @Column (name = "category")
    private String category;
    @Column (name = "status")
    private String status; // LOST, FOUND, CLAIMED
    
    
    @ManyToOne
    @JoinColumn(name = "reported_by")
    private User reportedBy;

    
    @ManyToOne
    @JoinColumn(name = "location_lost_id")
    private Location locationLost;

    @OneToOne(mappedBy = "lostItem")
    private ItemFound matchedFoundItem;

    @ManyToMany
    @JoinTable(
        name = "lost_item_categories",
        joinColumns = @JoinColumn(name = "lost_item_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<ItemCategory> categories;



    public LostItem() {

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



    public LocalDate getDateLost() {
        return dateLost;
    }



    public void setDateLost(LocalDate dateLost) {
        this.dateLost = dateLost;
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



    public User getReportedBy() {
        return reportedBy;
    }



    public void setReportedBy(User reportedBy) {
        this.reportedBy = reportedBy;
    }



    public Location getLocationLost() {
        return locationLost;
    }



    public void setLocationLost(Location locationLost) {
        this.locationLost = locationLost;
    }



    public ItemFound getMatchedFoundItem() {
        return matchedFoundItem;
    }



    public void setMatchedFoundItem(ItemFound matchedFoundItem) {
        this.matchedFoundItem = matchedFoundItem;
    }



    public Set<ItemCategory> getCategories() {
        return categories;
    }



    public void setCategories(Set<ItemCategory> categories) {
        this.categories = categories;
    }

    
    
    
}
