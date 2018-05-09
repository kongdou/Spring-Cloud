package fun.deepsky.springboot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2{

	  @Bean
	    public Docket configSpringfoxDocket_all(ApiInfo apiInfo) {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .produces(Sets.newHashSet("application/json"))
	                .consumes(Sets.newHashSet("application/json"))
	                .protocols(Sets.newHashSet("http", "https"))
	                .apiInfo(apiInfo)
	                .forCodeGeneration(true)
	                .select()
	                .build();
	    }

	    @Bean
	    public Docket createUserInfoRestApi(ApiInfo apiInfo) {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("user")
	                .produces(Sets.newHashSet("application/json"))
	                .consumes(Sets.newHashSet("application/json"))
	                .protocols(Sets.newHashSet("http", "https"))
	                .apiInfo(apiInfo)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("fun.deepsky.springboot.swagger.controller"))
	                .build();
	    }

	    @Bean
	    public ApiInfo apiInfo() {
	        return new ApiInfoBuilder().title("Springfox REST API")
	                .description("Descriptions.")
	                .termsOfServiceUrl("http://springfox.io")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
	                .version("2.0")
	                .build();
	    }
}
