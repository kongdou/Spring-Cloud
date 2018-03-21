package fun.deepsky.javamicroservice.book.service;

import fun.deepsky.javamicroservice.book.repository.Repository;

public abstract class BaseService<TE,T> extends ReadOnlyService<TE, T> {

	BaseService(Repository<TE, T> repository) {
		super(repository);
	}
	
}
