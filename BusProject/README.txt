RabbitMQ示例（需本地启动rabbitmq）：
SenderService--发送端
ReceiverService--接受端口




Bus示例：
1.在clientservice中引入：
        <dependency>
        	<groupId>org.springframework.cloud</groupId>
        	<artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
        
2.配置：bootsrap.properties文件：
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=test
spring.rabbitmq.password=123456

3.启动两个clientservice：
java jar xxx.jar --server.port=7001 
java jar xxx.jar --server.port=7002

修改svn/git配置文件，

执行：http://localhost:7002/bus/refresh
访问：http://localhost:7003/jdbc  数据已经发生变化





