package fun.deepsky.springboot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	@CachePut(key = "#person.id", value = "people")
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println(p.getName() + " - " + p.getAddress() + " : 已缓存");
		return p;
	}

	@Override
	@CacheEvict(value = "people")
	public void remove(Long id) {
		System.out.println("删除id为：" + id + " 的缓存数据");
		personRepository.delete(id);
	}

	@Override
	@Cacheable(key = "#person.id", value = "people")
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println(p.getName() + " - " + p.getAddress() + " : 已缓存");
		return p;
	}

}
