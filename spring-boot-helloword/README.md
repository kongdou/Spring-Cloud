Spring Boot基础
===
1.pom.xml引入依赖
---
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
	</dependency>
2.Application.java
---
	@SpringBootApplication
	@RestController
	public class Application {

	public static void main(String[] args) {
		//启动SpringBoot
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "hello world";
	}
	}
3.启动
---
	方式一：直接在IDE中运行
	方式二：根目录下运行 mvn spring-boot:run
	方式三：install安装，java -jar xxx.jar

Spring Boot配置文件
===

属性加载顺序
---
	1.命名行 java -jar xxx.jar --server.port=9090
	2.java系统属性 
	3.配置文件
	  application.properties
	  application.yml
多环境配置
---
	application.properties
	  spring.profile.active=test
	application-{profile}.properties
