package fun.deepsky.javamicroservice.user.service;

import fun.deepsky.javamicroservice.user.repository.Repository;

public abstract class ReadOnlyBaseService<TE,T> {

	Repository<TE, T> repository;
	
	ReadOnlyBaseService(Repository<TE, T> repository){
		this.repository = repository;
	}
	
	
	
}
