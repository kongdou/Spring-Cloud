package fun.deepsky.javamicroservice.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient 可以直接使用@EnableDiscoveryClient
@EnableDiscoveryClient
public class BookingServiceApp {

	public static void main(String[] args) {
		//设置优先级高于配置文件
		//System.setProperty("spring.application.name","booking-service");
		//System.setProperty("server.port", "8083");
		SpringApplication.run(BookingServiceApp.class, args);
	}
}
