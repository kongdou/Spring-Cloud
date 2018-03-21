package fun.deepsky.javamicroservice.sleuth;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthServiceApp1 {

	private final Logger logger = Logger.getLogger(SleuthServiceApp1.class);
	public static void main(String[] args) {
		SpringApplication.run(SleuthServiceApp1.class, args);
	}
	
	@RequestMapping(value="/trace-1",method=RequestMethod.GET)
	public String trace() {
		logger.info("call trace 1");
		return "Trace";
	}
	
}
