准备：
===
	1.启动EurenaService、RestaurantService、zuulService
	2.访问：http://localhost:8765/restaurantapi/restaurants?name=Meurice

Zuul限流spring-cloud-zuul-ratelimit
===
1.pom.xml增加依赖
---
		<dependency>
  			<groupId>com.marcosbarbero.cloud</groupId>
  			<artifactId>spring-cloud-zuul-ratelimit</artifactId>
  			<version>1.3.4.RELEASE</version>
		</dependency>

2.配置application.yml文件
---
	zuul:
	  ignoredServices: "*"  #忽略所有服务
	  routes:
	    restaurantapi:
	      path: /restaurantapi/**
	      serviceId: RestaurantService
	      stripPrefix: true
	  ratelimit:
	    repository: IN_MEMORY
	    enabled: true
	    key-prefix: your-prefix
	    behind-proxy: true
	    default-policy: 
	      limit: 10
	      quota: 1000
	      refresh-interval: 60 #刷新时间窗口的时间，默认值 (秒)
	      type:
	       - user
	       - origin
	       - url
	       
3.启动服务，测试
---
	连续调用12次，地址：http://localhost:8765/restaurantapi/restaurants?name=Meurice
	前10次返回结果：
	[
    {
        "id": "1",
        "name": "Le Meurice",
        "isModified": false,
        "tables": null,
        "address": "228 rue de Rivoli, 75001, Paris"
    }
    ]
	第11次之后结果显示：
	{
    "timestamp": 1522309887146,
    "status": 429,
    "error": "Too Many Requests",
    "exception": "com.netflix.zuul.exception.ZuulException",
    "message": "429"
    }
4.自定义限流策略，对请求属性name值进行限流
---
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
       
5.再次启动服务，测试
---
	1.调用15次：http://localhost:8765/restaurantapi/restaurants?name=Meurice
	      前10次正常显示：
	[
	    {
	        "id": "1",
	        "name": "Le Meurice",
	        "isModified": false,
	        "tables": null,
	        "address": "228 rue de Rivoli, 75001, Paris"
	    }
	]
	      第十一次之后显示：
	{
	    "timestamp": 1522309887146,
	    "status": 429,
	    "error": "Too Many Requests",
	    "exception": "com.netflix.zuul.exception.ZuulException",
	    "message": "429"
	}
	2.调用5次请求：http://localhost:8765/restaurantapi/restaurants?name=pierre
	显示正常：
	[
	    {
	        "id": "6",
	        "name": "Pierre Gagnaire",
	        "isModified": false,
	        "tables": null,
	        "address": "6, rue Balzac, 75008, Paris"
	    }
	]
	

注意：
===
	Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: private java.util.Map org.springframework.cloud.netflix.zuul.ZuulConfiguration$ZuulFilterConfiguration.filters; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'rateLimiterPreFilter' defined in class path resource [com/marcosbarbero/cloud/autoconfigure/zuul/ratelimit/RateLimitAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.netflix.zuul.ZuulFilter]: Factory method 'rateLimiterPreFilter' threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/cloud/netflix/zuul/util/ZuulRuntimeException
		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:573) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
		at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
		... 33 common frames omitted
		
	此异常是由于sping-boot版本低导致