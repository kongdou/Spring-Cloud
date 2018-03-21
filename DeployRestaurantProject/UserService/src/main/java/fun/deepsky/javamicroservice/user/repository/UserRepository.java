package fun.deepsky.javamicroservice.user.repository;

import java.util.Collection;

public interface UserRepository<User,String> extends Repository<User, String>{

	boolean containsName(String name);
	
	public Collection<User> findByName(String name) throws Exception;
	
}
