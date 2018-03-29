package fun.deepsky.javamicroservice.restaurant.service;

import fun.deepsky.javamicroservice.restaurant.repository.Repository;

public abstract class ReadOnlyBaseService<TE,T> {

	private Repository<TE,T> repository;
	
	ReadOnlyBaseService(Repository<TE,T> repository) {
		this.repository = repository;
	}
}
