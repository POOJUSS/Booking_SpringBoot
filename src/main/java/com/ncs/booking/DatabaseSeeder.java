package com.ncs.booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner :after application starts, bean created, application context created . classes which implements it are executed first. - we use here to create DB

@Component
public class DatabaseSeeder implements CommandLineRunner {
	private BookingRepository bookingRepository;
	
	@Autowired
	public DatabaseSeeder(BookingRepository bookingRepository)
	{
		this.bookingRepository= bookingRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		 List<HotelBooking> bookings = new ArrayList<>();
		 
		 bookings.add(new HotelBooking("Marriot",200.50,3));
		 bookings.add(new HotelBooking("Novotel",90.50,3));
		 bookings.add(new HotelBooking("Ibis",160,3));
		 
		 bookingRepository.saveAll(bookings);
		 
	}

}
