package com.Lost.FoundBackend.Lost.FoundBackend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lost.FoundBackend.Lost.FoundBackend.model.ItemFound;

@Repository
public interface ItemFoundRepository extends JpaRepository<ItemFound, UUID>  {

    List<ItemFound> findByNameContainingIgnoreCase(String name);

    List<ItemFound> findByColorIgnoreCase(String color);

    List<ItemFound> findByDateFound(LocalDate dateFound);

    List<ItemFound> findByCategory_Name(String categoryName);

    List<ItemFound> findByFoundBy_Id(UUID userId);

    List<ItemFound> findByLocation_Province(String province);

    List<ItemFound> findByLocation_District(String district);

    List<ItemFound> findByLocation_Sector(String sector);

    Boolean existsByNameAndFoundBy_Id(String name, UUID userId);

    Page<ItemFound> findAll(Pageable pageable);
}
