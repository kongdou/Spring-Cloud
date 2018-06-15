package fun.deepsky.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fun.deepsky.model.User;

@FeignClient(value="hello-service",fallback=HelloServiceFallBack.class)
public interface HelloService {
	
	@RequestMapping("/hello")
	public String hello();
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello(@RequestParam("name") String name);
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public String hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public String hello(@RequestBody User user);
	
}
