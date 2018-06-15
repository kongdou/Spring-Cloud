package fun.deepsky.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="HELLO-SERVICE")
public interface RefactorHelloService extends fun.deepsky.service.api.HelloService{

	
}
