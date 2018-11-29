package com.ncs.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/bookings")
public class BookingController {
	
	/*@RequestMapping("/hello")
	public String hello(){
		return"Hello";
	}
	
//	private List<HotelBooking> bookings;
    
	public BookingController() {
		/*bookings = new ArrayList<>();
		bookings.add(new HotelBooking("Marriot",200.50,3));
		bookings.add(new HotelBooking("Novotel",90.50,3));
		bookings.add(new HotelBooking("Ibis",160,3));
	}*/
	
	private BookingRepository bookingRepository;
	
	@Autowired
	public BookingController(BookingRepository bookingRepository)
	{
		this.bookingRepository= bookingRepository;
	}
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public List<HotelBooking> getAll(){
		return bookingRepository.findAll();
	}
	
	@RequestMapping(value="/affordable/{price}", method= RequestMethod.GET)
	public List<HotelBooking> getAffordable(@PathVariable double price){
//		return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
		return bookingRepository.findByPricePerNightLessThan(price);
	}
	
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
		/*bookings.add(hotelBooking);
		return bookings;*/
		bookingRepository.save(hotelBooking);
		return bookingRepository.findAll();
		
	}
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public List<HotelBooking> remove(@PathVariable HotelBooking id){
		/*bookings.add(hotelBooking);
		return bookings;*/
		bookingRepository.delete(id);;
		return bookingRepository.findAll();
		
	}
	
}
