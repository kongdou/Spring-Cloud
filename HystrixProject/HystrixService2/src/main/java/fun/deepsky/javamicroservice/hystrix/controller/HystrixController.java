package fun.deepsky.javamicroservice.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/hystrix/{id}")
	@HystrixCommand(fallbackMethod="defaultMethod")
	public String hello(@PathVariable("id") int id) {
		return "hello service:   "+id;
	}
	
	public String defaultMethod(@PathVariable int id) {
		return "helle service error:   "+id;
	}
	
}
