package fun.deepsky.javamicroservice.restaurant;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;


import fun.deepsky.javamicroservice.restaurant.controller.RestaurantController;
import fun.deepsky.javamicroservice.restaurant.domain.Entity;
import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;
import fun.deepsky.javamicroservice.restaurant.repository.RestaurantRepository;
import fun.deepsky.javamicroservice.restaurant.service.RestaurantService;
import fun.deepsky.javamicroservice.restaurant.service.RestaurantServiceImpl;

public class RestaurantControllerTests extends AbstractRestaurantControllerTests{

	
	protected class TestRestaurantRepository implements RestaurantRepository<Restaurant, String>{

		private Map<String, Restaurant> entities;

		public TestRestaurantRepository() {
			entities = new HashMap();
			Restaurant restaurant = new Restaurant("Le Meurice", "1", "228 rue de Rivoli, 75001, Paris", null);
			entities.put("1", restaurant);
			restaurant = new Restaurant("L'Ambroisie", "2", "9 place des Vosges, 75004, Paris", null);
			entities.put("2", restaurant);
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
			System.out.println(name);
			
			int noOfChars = name.length();
			entities.forEach((k,v) ->{System.out.println(v.getName().toLowerCase()+"===="+name.toLowerCase().substring(0, noOfChars));if(v.getName().toLowerCase().contains(name.toLowerCase().substring(0, noOfChars))) {
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
	
	protected RestaurantRepository testRestaurantRepository = new TestRestaurantRepository();
	
	protected RestaurantService restaurantService = new RestaurantServiceImpl(testRestaurantRepository);
	
	@Before
	public void setUp() {
		restaurantController = new RestaurantController(restaurantService);
	}
	
}
