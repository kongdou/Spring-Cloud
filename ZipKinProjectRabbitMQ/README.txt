服务端设置：
1.pom.xml
io.zipkin:zipkin-server 替换为以下：
		<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
        </dependency>
        
2.修改服务端Application
@EnableZipkinServer注解替换成@EnableZipkinStreamServer

3.配置增加rabbitMq：yml
  rabbitmq:
    host: localhost
    port: 5672
    username: test
    password: 123456
    
服务端完成

客户端配置：
spring-cloud-starter-zipkin替换为:
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
        </dependency>

增加rabbitmq配置：
#rabbitmq配置
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest


注释掉spring.zipkin.base-url

