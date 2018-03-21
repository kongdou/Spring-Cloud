package fun.deepsky.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fun.deepsky.springboot.domain.Person;

@Controller
@SpringBootApplication
public class Application {
	
	@RequestMapping("/getPerson")
	public String index(Model model){
		Person single = new Person("deepsky",30);
		
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("zhangsan",23);
		Person p2 = new Person("lisi",24);
		Person p3 = new Person("wangwu",25);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		
		return "person";
	}
	/**/
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}
	
	/*
	 * 第一种：注意类必须是static类型
	 */
	/*
	@Component
	public static class CustomSerlvetContainer implements
			EmbeddedServletContainerCustomizer {

		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
			container.setPort(8887);//配置端口
			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html")); //配置404页面
			container.setSessionTimeout(10,TimeUnit.MINUTES);//配置Session失效时间
		}
	}*/
	
	/*
	 * 第二种配置容器的方式
	 */
	/*
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
	
			TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
			factory.setPort(8886);
			factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
			factory.setSessionTimeout(10,TimeUnit.MINUTES);
			
			return factory;
	}*/
	/* 第三种配置容器的方式和第一种类似：新建组件@Component，实现EmbeddedServletContainerCustomizer接口中的方法
	 * 第四种配置容器的方式：直接在application.properties中配置server.port...
	 */
	
}
