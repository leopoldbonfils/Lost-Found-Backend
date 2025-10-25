package com.Lost.FoundBackend.Lost.FoundBackend.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "locations")
public class Location {
     
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "sector")
    private String sector;
    @Column(name = "cell")
    private String cell;
    @Column(name = "village")
    private String village;

    
    @OneToMany(mappedBy = "locationLost")
    private List<LostItem> lostItems;

    @OneToMany(mappedBy = "locationFound")
    private List<ItemFound> foundItems;


    public Location() {

    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getProvince() {
        return province;
    }


    public void setProvince(String province) {
        this.province = province;
    }


    public String getDistrict() {
        return district;
    }


    public void setDistrict(String district) {
        this.district = district;
    }


    public String getSector() {
        return sector;
    }


    public void setSector(String sector) {
        this.sector = sector;
    }


    public String getCell() {
        return cell;
    }


    public void setCell(String cell) {
        this.cell = cell;
    }


    public String getVillage() {
        return village;
    }


    public void setVillage(String village) {
        this.village = village;
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
