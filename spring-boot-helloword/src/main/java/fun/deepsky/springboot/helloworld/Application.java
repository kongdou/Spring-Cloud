package fun.deepsky.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		//System.setProperty("server.port", "9090");
		//启动SpringBoot
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "hello world";
	}
}
