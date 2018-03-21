package fun.deepsky.javamicroservice.book.service;

import fun.deepsky.javamicroservice.book.repository.Repository;

public abstract class ReadOnlyService<TE,T> {

	Repository<TE, T> repository;
	
	ReadOnlyService(Repository<TE, T> repository){
		this.repository = repository;
	}
	
}
