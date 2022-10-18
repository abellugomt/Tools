package com.example.Herramientas_G4.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Herramientas_G4.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByStartDateBetween(Date startDate, Date endDate);

    List<Reservation> findByStatus(String string);
}
