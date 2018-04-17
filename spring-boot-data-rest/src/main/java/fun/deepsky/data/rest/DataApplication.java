package fun.deepsky.data.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DataApplication.class);
		app.run(args);
	}
	
}
