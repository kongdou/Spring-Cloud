package fun.deepsky.javamicroservice.api.controller;

import java.util.List;


import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fun.deepsky.javamicroservice.api.domain.Restaurant;

@RestController
public class RestaurantServiceAPI {

	private static final Logger LOG = LoggerFactory.getLogger(RestaurantServiceAPI.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service")
	public List<String> home(){
		return discoveryClient.getServices();
	}
	/*
	@RequestMapping(value="/restaurants/{restaurantId}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultRestaurant",commandKey="helloKey")
    public String getRestaurant(@PathVariable("restaurantId") int restaurantId) {
        //MDC.put("restaurantId", restaurantId);
        String result = restTemplate.getForEntity("http://restaurantservice/restaurants/"+restaurantId, String.class).getBody();
        //LOG.info("GetRestaurant http-status: {}", result.getStatusCode());
        //LOG.debug("GetRestaurant body: {}", result.getBody());
        System.out.println(result);
        return result;
    }*/
	@RequestMapping(value="/restaurants/{restaurantId}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultRestaurant",commandKey="helloKey")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("restaurantId") int restaurantId) {
        MDC.put("restaurantId", restaurantId);
        ResponseEntity<Restaurant> result = restTemplate.getForEntity("http://restaurantservice/restaurants/"+restaurantId, Restaurant.class);
        LOG.info("GetRestaurant http-status: {}", result.getStatusCode());
        LOG.debug("GetRestaurant body: {}", result.getBody());
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
	
	public ResponseEntity<Restaurant> defaultRestaurant(int restaurantId) {
		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}
}
