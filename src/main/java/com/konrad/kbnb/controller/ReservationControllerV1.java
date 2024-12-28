package com.konrad.kbnb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.kbnb.Model.ReservationRequestBody;
import com.konrad.kbnb.entity.Reservation;
import com.konrad.kbnb.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationControllerV1 {
	

	private final ReservationService reservationService;
	
	public ReservationControllerV1(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@PostMapping("/add")
	public Reservation addReservation(@RequestBody ReservationRequestBody requestBody) {
		return reservationService.addReservation(requestBody);
	}

}
