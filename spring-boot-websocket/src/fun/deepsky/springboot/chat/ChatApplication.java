package fun.deepsky.springboot.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ChatApplication.class);
		app.run(args);
	}
}
