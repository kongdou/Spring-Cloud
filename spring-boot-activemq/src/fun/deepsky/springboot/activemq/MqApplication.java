package fun.deepsky.springboot.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class MqApplication implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MqApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("my-message", new Msg());
	}
}
