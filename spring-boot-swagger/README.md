Spring Boot 集成 Swagger
===

1.POM引入依赖
---
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.2.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.2.2</version>
		</dependency>
		
2.新增Swagger2类
---
	@Configuration
	@EnableSwagger2
	public class Swagger2{
	...
	}
3.新增controller类，添加注解@ApiOperation、@ApiImplicitParam、@ApiImplicitParams等
---
	public class SwaggerController{
	
		 ......
		 
	    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
	    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	    public String deleteUser(@PathVariable Long id) {
			userRepository.delete(id);
	        return "success";
	    }
	}

4.Swagger2类创建Dock类
---
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("fun.deepsky.springboot.swagger.controller"))
				.paths(PathSelectors.any()).build();
	}
	
5.resources下新增static/swagger
---
	在 GitHub 上下载 SwaggerUI 项目（https://github.com/swagger-api/swagger-ui）
	将dist下所有内容拷贝到本地项目resource/static/swagger下面, 并修改 index.html
	//url = "http://petstore.swagger.io/v2/swagger.json";        
	url = "http://localhost:8080/v2/api-docs";

6.启动，访问
---
	http://localhost:8080/swagger/index.html

