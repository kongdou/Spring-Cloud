package fun.deepsky.javamicroservice.restaurant.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import fun.deepsky.javamicroservice.restaurant.domain.Entity;
import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;

public interface RestaurantService {

	public void add(Restaurant restaurant) throws Exception;
	
	public void update(Restaurant restaurant) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public Entity findById(String id) throws Exception;
	
	public Collection<Restaurant> findByName(String name) throws Exception;
	
	public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
