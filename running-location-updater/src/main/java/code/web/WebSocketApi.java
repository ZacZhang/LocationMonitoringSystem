package code.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketApi {

	@MessageMapping("/sendMessage")
	@SendTo("/queue/locations")
	public String sendMessage(String message) throws Exception {
		return message;
	}
}
