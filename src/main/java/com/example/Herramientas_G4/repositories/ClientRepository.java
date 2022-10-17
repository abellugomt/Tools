package com.example.Herramientas_G4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Herramientas_G4.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
