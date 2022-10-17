package com.example.Herramientas_G4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Herramientas_G4.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
