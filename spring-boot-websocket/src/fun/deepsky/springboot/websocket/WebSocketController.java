package fun.deepsky.springboot.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public MyResponse sys(MyMessage message) throws Exception{
		Thread.sleep(3000);
		return new MyResponse("Welcome ,"+message.getName());
	}
}
