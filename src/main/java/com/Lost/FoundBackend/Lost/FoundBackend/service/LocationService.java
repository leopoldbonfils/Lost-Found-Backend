package com.Lost.FoundBackend.Lost.FoundBackend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Lost.FoundBackend.Lost.FoundBackend.model.Location;

import com.Lost.FoundBackend.Lost.FoundBackend.repository.LocationRepository;

@Service
public class LocationService {
    

    @Autowired
    private LocationRepository locationRepository;

    // Save location
    public String saveLocation(Location location){
        if(locationRepository.existsByProvinceAndDistrictAndSectorAndCellAndVillage(
            location.getProvince(),
            location.getDistrict(),
            location.getSector(),
            location.getCell(),
            location.getVillage()
        )){
            return "Location already exists";
        } else {
            locationRepository.save(location);
            return "Location saved successfully";
        }
    }

    // Get all locations
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    // Find by province
    public List<Location> getLocationsByProvince(String province){
        return locationRepository.findByProvince(province);
    }

    // Update location
    public String updateLocation(Location location){
        if(locationRepository.existsById(location.getId())){
            locationRepository.save(location);
            return "Location updated successfully";
        } else {
            return "Location not found";
        }
    }

    // Delete location
    public String deleteLocation(UUID id){
        if(locationRepository.existsById(id)){
            locationRepository.deleteById(id);
            return "Location deleted successfully";
        } else {
            return "Location not found";
        }
    }
}
