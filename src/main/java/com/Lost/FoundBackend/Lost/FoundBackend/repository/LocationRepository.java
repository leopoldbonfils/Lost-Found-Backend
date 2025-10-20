package com.Lost.FoundBackend.Lost.FoundBackend.repository;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Lost.FoundBackend.Lost.FoundBackend.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {

     
    List<Location> findByProvince(String province);

    List<Location> findByDistrict(String district);

    List<Location> findBySector(String sector);

    List<Location> findByCell(String cell);

    List<Location> findByVillage(String village);

    Boolean existsByProvinceAndDistrictAndSectorAndCellAndVillage( String province, String district, String sector, String cell, String village );

    Optional<Location> findByProvinceAndDistrict(String province, String district);

    Page<Location> findAll(Pageable pageable);
    
}
