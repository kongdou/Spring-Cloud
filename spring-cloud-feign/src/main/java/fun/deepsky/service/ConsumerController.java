package fun.deepsky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fun.deepsky.model.User;


@RestController
public class ConsumerController {

	@Autowired
	HelloService helloService;
	
	@Autowired
	RefactorHelloService refactorHelloService;
	
	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String hello() {
		return helloService.hello();
	}

	@RequestMapping(value = "/feign-consumer-new", method = RequestMethod.GET)
	public String hello2() {
		StringBuffer sb = new StringBuffer();
		//sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("deepsky")).append("\n");
		sb.append(helloService.hello("deepsky",30)).append("\n");
		sb.append(helloService.hello(new User("kongkong",31))).append("\n");
		return sb.toString();
	}
	
	@RequestMapping(value = "/feign-consumer-api", method = RequestMethod.GET)
	public String hello3() {
		StringBuffer sb = new StringBuffer();
		//sb.append(helloService.hello()).append("\n");
		sb.append(refactorHelloService.hello("kongdou")).append("\n");
		sb.append(refactorHelloService.hello("kongdou",31)).append("\n");
		sb.append(refactorHelloService.hello(new User("koudou",33))).append("\n");
		return sb.toString();
	}
	
	public String error(){
		return "error....";
	}
}
