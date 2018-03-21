package fun.deepsky.javamicroservice.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


@SpringBootApplication
@EnableZipkinStreamServer
@EnableEurekaClient
public class ZipKinServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(ZipKinServiceApp.class, args);
	}
}
