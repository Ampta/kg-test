package com.konrad.kbnb.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konrad.kbnb.Model.ReservationRequestBody;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	@Column
	private Date reservationDate;
	@Column
	private int numberOfGuests;
	
	@OneToOne
	@JoinColumn(name = "reservation_id")
	@JsonIgnore
	private Property reservationProperty;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Property getReservationProperty() {
		return reservationProperty;
	}

	public void setReservationProperty(Property reservationProperty) {
		this.reservationProperty = reservationProperty;
	}
	public static Reservation reservationFromDto(ReservationRequestBody reservationRequestBody){
        Reservation reservation = new Reservation();
        reservation.setReservationDate(reservationRequestBody.getReservationDate());
        reservation.setNumberOfGuests(reservationRequestBody.getNumberOfGuests());
        reservation.setReservationId(reservationRequestBody.getReservationId());
        return reservation;
    }
	
}
