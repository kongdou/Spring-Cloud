#指定配置文件前缀
spring.cloud.config.name=config
如果不指定此配置，需要spring.application.name配置为config

svn/git提交后需要post提交curl -d POST http://localhost:8082/refresh，才能获得最新的配置

更新时报错：
{
    "timestamp": 1520409866704,
    "status": 405,
    "error": "Method Not Allowed",
    "exception": "org.springframework.web.HttpRequestMethodNotSupportedException",
    "message": "Request method 'POST' not supported",
    "path": "/refresh"
}

必须引入：
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
