package fun.deepsky.springboot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

	@Autowired
	PersonService personService;

	@RequestMapping("/put")
	public Person put(Person person) {
		return personService.save(person);
	}

	@RequestMapping(value="/get",method=RequestMethod.GET)
	public Person cacheable(@Param("id") Long id) {
		Person person = new Person();
		person.setId(id);
		return personService.findOne(person);
	}

	@RequestMapping(value="/evit",method=RequestMethod.GET)
	public String evit(@Param("id") Long id){
		personService.remove(id);
		return "ok";
	}

}
