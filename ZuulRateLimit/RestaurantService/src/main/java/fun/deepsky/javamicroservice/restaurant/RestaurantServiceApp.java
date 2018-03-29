package fun.deepsky.javamicroservice.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApp.class, args);
	}
}
