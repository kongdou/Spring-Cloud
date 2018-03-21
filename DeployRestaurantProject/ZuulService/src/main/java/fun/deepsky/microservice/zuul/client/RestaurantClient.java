package fun.deepsky.microservice.zuul.client;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fun.deepsky.microservice.zuul.restaurant.domain.Restaurant;


@FeignClient("RestaurantService")
public interface RestaurantClient {

	@RequestMapping(method = RequestMethod.GET, value = "/restaurants")
    Collection<Restaurant> getRestaurants(@RequestParam("name") String name);
}
