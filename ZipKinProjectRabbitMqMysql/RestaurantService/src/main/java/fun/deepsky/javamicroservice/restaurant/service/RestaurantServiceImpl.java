package fun.deepsky.javamicroservice.restaurant.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.deepsky.javamicroservice.restaurant.domain.Entity;
import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;
import fun.deepsky.javamicroservice.restaurant.repository.Repository;
import fun.deepsky.javamicroservice.restaurant.repository.RestaurantRepository;

//标记为restaurantService服务，类似xml文件中bean id
@Service("restaurantService")
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService{


	private RestaurantRepository<Restaurant, String> restaurantRepository;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository<Restaurant, String> restaurantRepository) {
		super(restaurantRepository);
		this.restaurantRepository = restaurantRepository;
	}
	
	
	@Override
	public void update(Restaurant restaurant) throws Exception {
		restaurantRepository.update(restaurant);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		restaurantRepository.remove(id);
	}

	@Override
	public Entity findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return restaurantRepository.get(id);
	}

	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return restaurantRepository.findByName(name);
	}

	@Override
	public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Restaurant restaurant) throws Exception{
		if (restaurantRepository.containsName(restaurant.getName())) {
	         throw new Exception(String.format("There is already a product with the name - %s", restaurant.getName()));
	    }

	    if (restaurant.getName() == null || "".equals(restaurant.getName())) {
	         throw new Exception("Restaurant name cannot be null or empty string.");
	    }
	    super.add(restaurant);
	}
	
}
