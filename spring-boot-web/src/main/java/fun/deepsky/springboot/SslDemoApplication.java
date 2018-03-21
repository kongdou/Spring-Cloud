package fun.deepsky.springboot;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fun.deepsky.springboot.domain.Person;

@RestController
@SpringBootApplication
public class SslDemoApplication {

	@RequestMapping("/index")
	public String index(Model model) {
		Person single = new Person("deepsky", 30);

		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("zhangsan", 23);
		Person p2 = new Person("lisi", 24);
		Person p3 = new Person("wangwu", 25);
		people.add(p1);
		people.add(p2);
		people.add(p3);

		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);

		return "index";
	}
	
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
	
			TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(){
				
				protected void postProcessContext(Context context){
					SecurityConstraint securityConstraint = new SecurityConstraint();
					securityConstraint.setUserConstraint("CONFIDENTIAL");
					SecurityCollection securityCollection = new SecurityCollection();
					securityCollection.addPattern("/*");
					securityConstraint.addCollection(securityCollection);
					context.addConstraint(securityConstraint);
					
				}
			};
			
			factory.addAdditionalTomcatConnectors(httpConnector());
			
			return factory;
	}

	@Bean
	public Connector httpConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8081);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SslDemoApplication.class);
		app.run(args);
	}

}
