package fun.deepsky.springcloud.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

	@Autowired
	LoadBalancerClient loadBalancer;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/discovery")
	public String disCovery() {
		return loadBalancer.choose("tomcat").getUri().toString();
	}
	
	  /** 
     * 获取所有服务  
     */  
    @RequestMapping("/services")  
    public Object services() {  
        return discoveryClient.getInstances("tomcat");  
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
