package com.Lost.FoundBackend.Lost.FoundBackend.model;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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


    @OneToMany(mappedBy = "location")
    private List<User> users;

    
    public Location() {}
    
    public Location(String province, String district, String sector, String cell, String village) {
        this.province = province;
        this.district = district;
        this.sector = sector;
        this.cell = cell;
        this.village = village;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    
    
   
}
