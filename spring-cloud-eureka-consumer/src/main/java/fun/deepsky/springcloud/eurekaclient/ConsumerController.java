package fun.deepsky.springcloud.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/invokeHello/{message}",method= RequestMethod.GET)
	public String invokeHello(@PathVariable("message") String message) {
		return (String)restTemplate.getForObject("http://SERVICE-PROVIDER/hello/{message}", String.class,message);
	}
}
