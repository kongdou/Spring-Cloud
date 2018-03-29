package fun.deepsky.microservice.zuul.limitstrategy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.DefaultRateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;

@Component
public class LimitStrategy {
	
	@Bean
	public RateLimitKeyGenerator rateLimitKeyGenerator(final RateLimitProperties properties) {
		return new DefaultRateLimitKeyGenerator(properties) {
			public String key(HttpServletRequest request,Route route,RateLimitProperties.Policy policy) {
				System.out.println(super.key(request, route, policy)+"============="+request.getParameter("name"));
				return super.key(request, route, policy)+":"+request.getParameter("name");
			}
		};
	}
}
