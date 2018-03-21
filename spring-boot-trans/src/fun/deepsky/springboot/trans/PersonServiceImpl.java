package fun.deepsky.springboot.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Transactional(rollbackFor={IllegalArgumentException.class})
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);
		
		if(p.getName().equals("xx")){
			throw new IllegalArgumentException("数据存在，回滚");
		}
		return p;
	}

	@Transactional(noRollbackFor={IllegalArgumentException.class})
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);
		
		if(p.getName().equals("xx")){
			throw new IllegalArgumentException("数据存在，不回滚");
		}
		return p;
	}

}
