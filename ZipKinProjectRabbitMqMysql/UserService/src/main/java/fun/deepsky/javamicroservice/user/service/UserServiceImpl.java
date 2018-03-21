package fun.deepsky.javamicroservice.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.deepsky.javamicroservice.user.domain.Entity;
import fun.deepsky.javamicroservice.user.domain.User;
import fun.deepsky.javamicroservice.user.repository.UserRepository;

@Service("userService")
public class UserServiceImpl extends BaseService<User,String> implements UserService {

	private UserRepository<User, String> userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository<User, String> userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}

	@Override
	public void add(User user) throws Exception {
		userRepository.add(user);
	}

	@Override
	public void update(User user) throws Exception {
		userRepository.update(user);
	}

	@Override
	public void delete(String id) throws Exception {
		userRepository.remove(id);
	}
	
	@Override
	public Entity findById(String id) throws Exception {
		return userRepository.get(id);
	}

	@Override
	public Collection<User> findByName(String name) throws Exception {
		return userRepository.findByName(name);
	}

	@Override
	public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
		return null;
	}

}
