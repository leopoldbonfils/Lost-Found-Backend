package com.Lost.FoundBackend.Lost.FoundBackend.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Lost.FoundBackend.Lost.FoundBackend.model.ItemCategory;

@Repository
public interface CategoryRepository extends JpaRepository<ItemCategory, UUID> {

    Optional<ItemCategory> findByName(String name);

   
    List<ItemCategory> findByNameContainingIgnoreCase(String name);

    
    Boolean existsByName(String name);

   
    List<ItemCategory> findByCategoryTypeIgnoreCase(String categoryType);

   
    Page<ItemCategory> findAll(Pageable pageable);

    
}
