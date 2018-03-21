package fun.deepsky.springboot.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import fun.deepsky.springboot.batch.domain.Person;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

	@Override
	public Person process(Person item) throws ValidationException {
		super.process(item);
		if (item.getNation().equals("汉族")) {
			item.setNation("01");
		} else if (item.getNation().equals("回族")) {
			item.setNation("02");
		} else {
			item.setNation("99");
		}
		return item;
	}
}
