package fun.deepsky.javamicroservice.bus.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RabbitListener(queues="hello")
public class ReceiverApp {

	public static void main(String[] args) {
		SpringApplication.run(ReceiverApp.class, args);
	}
	
	@RabbitHandler
	public void process(String msg) {
		System.out.println("接收到消息："+msg);
	}
	
}
