package fun.deepsky.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {


	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
	public String helloCo() {
		return helloService.helloService();
	}

}
