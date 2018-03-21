package fun.deepsky.javamicroservice.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryClientSample implements CommandLineRunner {

	@Autowired
	private DiscoveryClient discoveryClient; 
	
	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println(discoveryClient.description());
		
	}

}
