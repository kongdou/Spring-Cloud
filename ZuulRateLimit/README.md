准备：
===
	1.启动EurenaService、RestaurantService、zuulService
	2.访问：http://localhost:8765/restaurantapi/restaurants/1 路由到 http://localhost:8081/restaurants/1

Zuul限流spring-cloud-zuul-ratelimit
===
1.pom.xml增加依赖
---
		<dependency>
  			<groupId>com.marcosbarbero.cloud</groupId>
  			<artifactId>spring-cloud-zuul-ratelimit</artifactId>
  			<version>1.3.4.RELEASE</version>
		</dependency>

2配置application.yml文件
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
调用15次：
http://localhost:8765/restaurantapi/restaurants?name=Meurice
前十次正常显示：
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
调用5次以下请求：
http://localhost:8765/restaurantapi/restaurants?name=pierre
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

