package fun.deepsky.javamicroservice.restaurant.repository;

import java.util.Collection;

import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;

public interface RestaurantRepository<Restaurant,String> extends Repository<Restaurant, String> {

	public Collection<Restaurant> findByName(String name) throws Exception;
	
	boolean containsName(String name);
}
