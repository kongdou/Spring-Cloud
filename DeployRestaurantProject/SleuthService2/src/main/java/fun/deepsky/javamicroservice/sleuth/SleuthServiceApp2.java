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
public class SleuthServiceApp2 {

	private final Logger logger = Logger.getLogger(SleuthServiceApp2.class);
	public static void main(String[] args) {
		SpringApplication.run(SleuthServiceApp2.class, args);
	}
	
	@RequestMapping(value="/trace-2",method=RequestMethod.GET)
	public String trace() {
		logger.info("call trace 2");
		return "Trace";
	}
	
}
