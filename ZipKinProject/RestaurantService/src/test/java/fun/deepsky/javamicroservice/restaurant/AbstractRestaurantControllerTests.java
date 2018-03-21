package fun.deepsky.javamicroservice.restaurant;

import java.util.Collection;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import fun.deepsky.javamicroservice.restaurant.controller.RestaurantController;
import fun.deepsky.javamicroservice.restaurant.domain.Entity;
import fun.deepsky.javamicroservice.restaurant.domain.Restaurant;
import fun.deepsky.javamicroservice.restaurant.vo.RestaurantVO;


public abstract class AbstractRestaurantControllerTests {

	protected final static String RESTAURANT = "1";

	protected final static String RESTAURANT_NAME = "Le Meurice";
	
	 protected static final String RESTAURANT_ADDRESS = "228 rue de Rivoli, 75001, Paris";
	 
	 @Autowired
	 RestaurantController restaurantController;
	 
	 @Test
	 public void validResturantById() {
		 Logger.getGlobal().info("Start validResturantById test");
		 ResponseEntity<Entity> restaurant = restaurantController.findById(RESTAURANT);
		 Assert.assertEquals(HttpStatus.OK, restaurant.getStatusCode());
		 Assert.assertTrue(restaurant.hasBody());
		 Assert.assertNotNull(restaurant.getBody());
		 Assert.assertEquals(RESTAURANT, restaurant.getBody().getId());
		 Assert.assertEquals(RESTAURANT_NAME, restaurant.getBody().getName());
		 Logger.getGlobal().info("End validResturantById test");
	 }
	 
	    /**
	     * Test method for findByName method
	     */
	    @Test
	    public void validResturantByName() {
	        Logger.getGlobal().info("Start validResturantByName test");
	        ResponseEntity<Collection<Restaurant>> restaurants = restaurantController.findByName(RESTAURANT_NAME);
	        Logger.getGlobal().info("In validAccount test");

	        Assert.assertEquals(HttpStatus.OK, restaurants.getStatusCode());
	        Assert.assertTrue(restaurants.hasBody());
	        Assert.assertNotNull(restaurants.getBody());
	        Assert.assertFalse(restaurants.getBody().isEmpty());
	        Restaurant restaurant = (Restaurant) restaurants.getBody().toArray()[0];
	        Assert.assertEquals(RESTAURANT, restaurant.getId());
	        Assert.assertEquals(RESTAURANT_NAME, restaurant.getName());
	        Logger.getGlobal().info("End validResturantByName test");
	    }

	    /**
	     * Test method for add method
	     */
	    @Test
	    public void validAdd() {
	        Logger.getGlobal().info("Start validAdd test");
	        RestaurantVO restaurant = new RestaurantVO();
	        restaurant.setId("999");
	        restaurant.setName("Test Restaurant");

	        ResponseEntity<Restaurant> restaurants = restaurantController.add(restaurant);
	        Assert.assertEquals(HttpStatus.CREATED, restaurants.getStatusCode());
	        Logger.getGlobal().info("End validAdd test");
	    }
}
