package fun.deepsky.javamicroservice.book.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.deepsky.javamicroservice.book.domain.Booking;
import fun.deepsky.javamicroservice.book.domain.Entity;
import fun.deepsky.javamicroservice.book.repository.BookingRepository;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	private BookingRepository<Booking, String> bookingRepository;
	
	@Autowired
	public BookingServiceImpl(BookingRepository<Booking, String> bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	@Override
	public void add(Booking booking) throws Exception {
		bookingRepository.add(booking);
		
	}

	@Override
	public void update(Booking booking) throws Exception {
		bookingRepository.update(booking);
		
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		bookingRepository.remove(id);
		
	}

	@Override
	public Entity findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return bookingRepository.get(id);
	}

	@Override
	public Collection<Booking> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return bookingRepository.findByName(name);
	}

	@Override
	public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
