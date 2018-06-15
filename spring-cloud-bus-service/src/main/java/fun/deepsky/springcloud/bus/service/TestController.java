package fun.deepsky.springcloud.bus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

	@Value("${config-server.name}")
	private String name;
	
	@RequestMapping(value="/getName",method=RequestMethod.GET)
	public String getConfigValue() {
		return this.name;
	}
}
