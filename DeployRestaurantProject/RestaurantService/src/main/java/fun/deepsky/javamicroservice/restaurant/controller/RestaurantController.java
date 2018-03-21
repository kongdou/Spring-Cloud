package fun.deepsky.javamicroservice.restaurant.controller;

import java.util.Collection;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.deepsky.javamicroservice.restaurant.domain.Entity;
import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;
import fun.deepsky.javamicroservice.restaurant.service.RestaurantService;
import fun.deepsky.javamicroservice.restaurant.vo.RestaurantVO;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	protected Logger logger = Logger.getLogger(RestaurantController.class);

	protected RestaurantService restaurantService;
	
	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {
		logger.info(String.format("restaurants-service findByName() invoke:{} for {}",
				restaurantService.getClass().getName(), name));
		Collection<Restaurant> restaurants;
		try {
			restaurants = restaurantService.findByName(name);
		} catch (Exception e) {
			return new ResponseEntity<Collection<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return restaurants.size() > 0 ? new ResponseEntity<Collection<Restaurant>>(restaurants, HttpStatus.OK)
				: new ResponseEntity<Collection<Restaurant>>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{restaurant_id}",method=RequestMethod.GET)
	public ResponseEntity<Entity> findById(@PathVariable("restaurant_id") String id){
		logger.info(String.format("restaurants-service findByid() invoke:{} for {}",
				restaurantService.getClass().getName(), id));
		Entity restaurant;
		try {
			restaurant = restaurantService.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Entity>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return restaurant != null?  new ResponseEntity<Entity>(restaurant, HttpStatus.OK):new ResponseEntity<Entity>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Restaurant> add(@RequestBody RestaurantVO restaurantVO){
		logger.info(String.format("restaurants-service add() invoke:{} for {}",
				restaurantService.getClass().getName(), restaurantVO.getName()));
		
		Restaurant restaurant = new Restaurant(null, null, null, null);
		BeanUtils.copyProperties(restaurantVO, restaurant);
		try {
			restaurantService.add(restaurant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		    return new ResponseEntity<Restaurant>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
	}

}
