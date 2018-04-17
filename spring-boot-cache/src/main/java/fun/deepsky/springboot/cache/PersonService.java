package fun.deepsky.springboot.cache;

public interface PersonService {

	public Person save(Person person);

	public void remove(Long id);

	public Person findOne(Person person);
}
