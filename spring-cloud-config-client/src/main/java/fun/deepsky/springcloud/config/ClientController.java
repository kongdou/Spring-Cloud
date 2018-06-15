package fun.deepsky.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {

	@Value("${config-server.name}")
	private String name;
	
	@RequestMapping(value="/name",method=RequestMethod.GET)
	public String getConfigServerName() {
		return this.name;
	}
}
