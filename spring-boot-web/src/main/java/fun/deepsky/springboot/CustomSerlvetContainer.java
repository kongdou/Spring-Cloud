package fun.deepsky.springboot;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component 暂注释
public class CustomSerlvetContainer implements
		EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8886);//配置端口
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html")); //配置404页面
		container.setSessionTimeout(10,TimeUnit.MINUTES);//配置Session失效时间
	}

}
