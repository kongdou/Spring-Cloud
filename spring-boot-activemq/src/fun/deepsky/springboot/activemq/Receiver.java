package fun.deepsky.springboot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "my-message")
	public void receiveMessage(String message) {
		System.out.println("接收到：" + message);
	}
}
