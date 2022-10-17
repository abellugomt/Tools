package com.example.Herramientas_G4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Herramientas_G4.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
