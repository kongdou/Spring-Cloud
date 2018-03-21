package fun.deepsky.javamicroservice.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipKinServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(ZipKinServiceApp.class, args);
	}
}
