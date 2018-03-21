package fun.deepsky.springboot.batch;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {

	private javax.validation.Validator validator;

	//validator初始化
	@Override
	public void afterPropertiesSet() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.usingContext().getValidator();
	}

	//数据验证
	@Override
	public void validate(T value) throws ValidationException {

		Set<ConstraintViolation<T>> violations = validator.validate(value);

		if (violations.size() > 0) {
			StringBuffer message = new StringBuffer();
			for (ConstraintViolation<T> constraintViolation : violations) {
				message.append(constraintViolation.getMessage() + "\n");
			}
			throw new ValidationException(message.toString());
		}

	}

}
