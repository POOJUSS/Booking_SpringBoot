package com.ncs.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<HotelBooking , Long> {
 List<HotelBooking> findByPricePerNightLessThan(double price);
}
