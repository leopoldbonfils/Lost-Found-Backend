package com.Lost.FoundBackend.Lost.FoundBackend.repository;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lost.FoundBackend.Lost.FoundBackend.model.LostItem;

@Repository
public interface LostItemRepository extends JpaRepository<LostItem, UUID> {

    List<LostItem> findByNameContainingIgnoreCase(String name);

    List<LostItem> findByColorIgnoreCase(String color);

    List<LostItem> findByDateLost(LocalDate dateLost);

    List<LostItem> findByCategory_Name(String categoryName);

    List<LostItem> findByUser_Id(UUID userId);

    List<LostItem> findByLocation_Province(String province);

    List<LostItem> findByLocation_District(String district);

    List<LostItem> findByLocation_Sector(String sector);

    Boolean existsByNameAndUser_Id(String name, UUID userId);

    Page<LostItem> findAll(Pageable pageable);
}
