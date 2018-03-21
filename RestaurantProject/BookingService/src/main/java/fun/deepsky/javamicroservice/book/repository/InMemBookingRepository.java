package fun.deepsky.javamicroservice.book.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fun.deepsky.javamicroservice.book.domain.Booking;
import fun.deepsky.javamicroservice.book.domain.Entity;

@Repository("bookingRepository")
public class InMemBookingRepository implements BookingRepository<Booking, String> {

	private Map<String, Booking> entities;
	 
	public InMemBookingRepository() {
		entities = new HashMap();
        Booking booking = new Booking("1", "Booking 1", "1", "1", "1", LocalDate.now(), LocalTime.now());
        entities.put("1", booking);
        Booking booking2 = new Booking("2", "Booking 2", "2", "2", "2", LocalDate.now(), LocalTime.now());
        entities.put("2", booking2);
	}
	
	@Override
	public void add(Booking entity) {
		entities.put(entity.getId(), entity);
	}

	@Override
	public void remove(String id) {
		if(entities.containsKey(id)) {
			entities.remove(id);
		}
		
	}

	@Override
	public void update(Booking entity) {
		if(entities.containsKey(entity.getId())) {
			entities.put(entity.getId(), entity);
		}
		
	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return entities.containsKey(id);
	}

	@Override
	public Entity get(String id) {
		// TODO Auto-generated method stub
		return entities.get(id);
	}

	@Override
	public Collection<Booking> getAll() {
		// TODO Auto-generated method stub
		return entities.values();
	}

	@Override
	public boolean containsName(String name) {
		// TODO Auto-generated method stub
		try {
			return this.findByName(name).size() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Collection<Booking> findByName(String name) throws Exception {
		List<Booking> bookings = new ArrayList<>();
		entities.forEach((k,v)->{
			if(v.getName().toLowerCase().contains(name.toLowerCase())) {
				bookings.add(v);
			}
		});
		return bookings;
	}

}
