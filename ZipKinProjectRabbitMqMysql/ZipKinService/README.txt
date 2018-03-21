引入：
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		
修改配置文件：
  sleuth:
    enabled: false
  datasource:
    schema: classpath:/zipkin.sql
    url: jdbc:mysql://localhost:3306/zipkin
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver
    initialize: true
    continue-on-error: true
    
    

创建zipkin数据库
手动执行：zipkin-storage-mysql.1.1.1.jar包下的zipkin.sql文件（不知道为什么initialize: true没作用。。。）


由于版本的问题，需要引入：
		<!-- 版本问题 -->
		<dependency>
			<groupId>org.jooq</groupId>
			<artifactId>jooq</artifactId>
			<version>3.8.2</version>
			</dependency>


