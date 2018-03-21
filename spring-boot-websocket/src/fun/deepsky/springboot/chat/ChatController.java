package fun.deepsky.springboot.chat;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	@Autowired
	private SimpMessagingTemplate messageTemplate; //向浏览器发送消息

	@MessageMapping("/chat")
	public void handlerChat(Principal principal, String msg) {
		if (principal.getName().equals("deepsky")) {
			messageTemplate.convertAndSendToUser("kongkong",
					"/queue/notifications", principal.getName() + " send:"
							+ msg);
		} else {
			messageTemplate.convertAndSendToUser("deepsky",
					"/queue/notifications", principal.getName() + " send:"
							+ msg);
		}
	}

}
