package fun.deepsky.javamicroservice.user.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fun.deepsky.javamicroservice.user.domain.Entity;
import fun.deepsky.javamicroservice.user.domain.User;

@Repository("userRepository")
public class InMemUserRepository implements UserRepository<User, String> {

	private Map<String, User> entities;

	public InMemUserRepository() {
		entities = new HashMap();
		User user = new User("1", "User Name 1", "Address 1", "City 1", "9999911111");
		entities.put("1", user);
		User user2 = new User("1", "User Name 2", "Address 2", "City 2", "9999922222");
		entities.put("2", user2);
	}

	@Override
	public boolean contains(String id) {

		return entities.containsKey(id);
	}

	@Override
	public Entity get(String id) {
		// TODO Auto-generated method stub
		return entities.get(id);
	}

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		return entities.values();
	}

	@Override
	public boolean containsName(String name) {
		try {
			return findByName(name).size() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Collection<User> findByName(String name) throws Exception {

		List<User> users = new ArrayList<User>();

		entities.forEach((k, v) -> {
			if (v.getName().toLowerCase().contains(name.toLowerCase())) {
				users.add(v);
			}
		});
		return users;
	}

	@Override
	public void add(User entity) {
		entities.put(entity.getId(), entity);

	}

	@Override
	public void remove(String id) {
		if (entities.containsKey(id)) {
			entities.remove(id);
		}

	}

	@Override
	public void update(User entity) {
		if (entities.containsKey(entity.getId())) {
			entities.put(entity.getId(), entity);
		}
	}

}
