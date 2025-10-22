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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.util.List;
import com.Lost.FoundBackend.Lost.FoundBackend.model.Location;

import com.Lost.FoundBackend.Lost.FoundBackend.service.LocationService;


@RestController
@RequestMapping(value = "/api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // ✅ Save Location
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveLocation(@RequestBody Location location) {
        String response = locationService.saveLocation(location);

        if (response.equalsIgnoreCase("Location already exists")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    // ✅ Get All Locations
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    // ✅ Get Locations by Province
    @GetMapping(value = "/province/{province}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getLocationsByProvince(@PathVariable("province") String province) {
        return ResponseEntity.ok(locationService.getLocationsByProvince(province));
    }

    // ✅ Update Location
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateLocation(@RequestBody Location location) {
        String response = locationService.updateLocation(location);

        if (response.equalsIgnoreCase("Location not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    // ✅ Delete Location by ID
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") UUID id) {
        String response = locationService.deleteLocation(id);

        if (response.equalsIgnoreCase("Location not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }
    
}
