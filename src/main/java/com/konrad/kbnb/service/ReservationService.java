package com.konrad.kbnb.service;

import org.springframework.stereotype.Service;

import com.konrad.kbnb.Model.ReservationRequestBody;
import com.konrad.kbnb.entity.Reservation;
import com.konrad.kbnb.repository.ReservationRepo;

@Service
public class ReservationService {
	private final ReservationRepo reservationRepo;

	public ReservationService(ReservationRepo reservationRepo) {
		super();
		this.reservationRepo = reservationRepo;
	}
	
	
	public Reservation addReservation(ReservationRequestBody requestBody) {
		Reservation reservation = Reservation.reservationFromDto(requestBody);
		return reservationRepo.save(reservation);
	}
	
	
}
