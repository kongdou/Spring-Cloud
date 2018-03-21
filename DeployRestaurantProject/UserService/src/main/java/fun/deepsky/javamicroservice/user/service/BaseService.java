package fun.deepsky.javamicroservice.user.service;

import fun.deepsky.javamicroservice.user.repository.Repository;

public abstract class BaseService<TE,T> extends ReadOnlyBaseService<TE, T> {

	private Repository<TE, T> _repository;
	
	BaseService(Repository<TE, T> repository) {
		super(repository);
		this._repository = repository;
	}
	
	public void add(TE entity) throws Exception{
		_repository.add(entity);
	}
	
	public void remove(T id) throws Exception{
		_repository.remove(id);
	}

	public void update(TE entity)throws Exception {
		_repository.update(entity);
	}
}
