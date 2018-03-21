package fun.deepsky.springboot.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

	@Autowired
	PersonService personService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person){
		return personService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person norollback(Person person){
		return personService.savePersonWithoutRollBack(person);
	}
}
