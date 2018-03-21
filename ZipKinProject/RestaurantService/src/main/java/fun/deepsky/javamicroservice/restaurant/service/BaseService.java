package fun.deepsky.javamicroservice.restaurant.service;

import java.util.Collection;

import fun.deepsky.javamicroservice.restaurant.repository.Repository;

public abstract class BaseService<TE,T> extends ReadOnlyBaseService<TE, T>{

	private Repository<TE,T> _repository;
	BaseService(Repository<TE, T> repository) {
		super(repository);
		this._repository = repository;
	}

	public void add(TE entity) throws Exception{
		_repository.add(entity);
	}
	
	public Collection<TE> getAll(){
		return _repository.getAll();
	}
	
}
