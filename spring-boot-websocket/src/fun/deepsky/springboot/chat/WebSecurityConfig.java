package fun.deepsky.springboot.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		// 不拦截/和/login路径
		http.authorizeRequests().antMatchers("/", "/login").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login")// 登录页面的访问路径为/login
				.defaultSuccessUrl("/chat").permitAll()// 登录成功后跳转到/chat路径
				.and().logout().permitAll();
	}

	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// 内存中存放两个用户
		auth.inMemoryAuthentication().withUser("deepsky").password("123456")
				.roles("USER").and().withUser("kongkong").password("123456")
				.roles("USER");
	}

	public void configure(WebSecurity web) throws Exception {
		// 不拦截static下的资源
		web.ignoring().antMatchers("/resources/static/**");
	}
}
