package fun.deepsky.javamicroservice.bus.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SenderApp {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@RequestMapping("/send")
	public String sendMessge(@RequestParam("msg") String msg) {
		String message = "Send Message:"+msg;
		this.amqpTemplate.convertAndSend("hello",msg);
		return message;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SenderApp.class, args);
	}
	
}
