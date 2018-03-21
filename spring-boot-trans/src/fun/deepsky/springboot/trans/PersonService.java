package fun.deepsky.springboot.trans;

public interface PersonService {
	public Person savePersonWithRollBack(Person person);

	public Person savePersonWithoutRollBack(Person person);
}
