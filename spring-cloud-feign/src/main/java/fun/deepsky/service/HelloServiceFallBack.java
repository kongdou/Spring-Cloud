package fun.deepsky.service;

import org.springframework.stereotype.Component;

import fun.deepsky.model.User;

@Component
public class HelloServiceFallBack implements HelloService{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "error 100";
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "error 2";
	}

	@Override
	public String hello(String name, Integer age) {
		// TODO Auto-generated method stub
		return "error 3";
	}

	@Override
	public String hello(User user) {
		// TODO Auto-generated method stub
		return "error 4";
	}

}
