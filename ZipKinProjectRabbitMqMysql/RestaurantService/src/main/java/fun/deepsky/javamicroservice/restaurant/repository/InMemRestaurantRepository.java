package fun.deepsky.javamicroservice.restaurant.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fun.deepsky.javamicroservice.restaurant.domain.Entity;
import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;

@Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {

	private Map<String, Restaurant> entities;

	public InMemRestaurantRepository() {
		entities = new HashMap();
		Restaurant restaurant = new Restaurant("Le Meurice", "1", "228 rue de Rivoli, 75001, Paris", null);
		entities.put("1", restaurant);
		restaurant = new Restaurant("L'Ambroisie", "2", "9 place des Vosges, 75004, Paris", null);
		entities.put("2", restaurant);
		restaurant = new Restaurant("Arpège", "3", "84, rue de Varenne, 75007, Paris", null);
		entities.put("3", restaurant);
		restaurant = new Restaurant("Alain Ducasse au Plaza Athénée", "4", "25 avenue de Montaigne, 75008, Paris",
				null);
		entities.put("4", restaurant);
		restaurant = new Restaurant("Pavillon LeDoyen", "5", "1, avenue Dutuit, 75008, Paris", null);
		entities.put("5", restaurant);
		restaurant = new Restaurant("Pierre Gagnaire", "6", "6, rue Balzac, 75008, Paris", null);
		entities.put("6", restaurant);
		restaurant = new Restaurant("L'Astrance", "7", "4, rue Beethoven, 75016, Paris", null);
		entities.put("7", restaurant);
		restaurant = new Restaurant("Pré Catelan", "8", "Bois de Boulogne, 75016, Paris", null);
		entities.put("8", restaurant);
		restaurant = new Restaurant("Guy Savoy", "9", "18 rue Troyon, 75017, Paris", null);
		entities.put("9", restaurant);
		restaurant = new Restaurant("Le Bristol", "10", "112, rue du Faubourg St Honoré, 8th arrondissement, Paris",
				null);
		entities.put("10", restaurant);
	}

	@Override
	public void add(Restaurant entity) {
		 entities.put(entity.getId(), entity);
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		entities.remove(id);
	}

	@Override
	public void update(Restaurant entity) {
		// TODO Auto-generated method stub
		if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
	}

	@Override
	public boolean contains() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity get(String id) {
		// TODO Auto-generated method stub
		return entities.get(id);
	}

	@Override
	public Collection<Restaurant> getAll() {
		// TODO Auto-generated method stub
		return entities.values();
	}

	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		Collection<Restaurant> restaurants = new ArrayList();
		int noOfChars = name.length();
		entities.forEach((k,v) ->{if(v.getName().toLowerCase().contains(name.toLowerCase().substring(0, noOfChars))) {
			restaurants.add(v);
		}});
		return restaurants;
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

}
