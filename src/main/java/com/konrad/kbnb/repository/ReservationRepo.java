package com.konrad.kbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konrad.kbnb.entity.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long>{
	Reservation save(Reservation reservation);
}
