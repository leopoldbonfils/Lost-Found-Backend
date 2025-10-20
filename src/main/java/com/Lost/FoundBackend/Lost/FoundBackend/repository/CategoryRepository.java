package com.Lost.FoundBackend.Lost.FoundBackend.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Lost.FoundBackend.Lost.FoundBackend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Optional<Category> findByName(String name);

   
    List<Category> findByNameContainingIgnoreCase(String name);

    
    Boolean existsByName(String name);

   
    List<Category> findByCategoryTypeIgnoreCase(String categoryType);

   
    Page<Category> findAll(Pageable pageable);

    
}
