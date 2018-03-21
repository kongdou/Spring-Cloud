package fun.deepsky.javamicroservice.user.repository;

import java.util.Collection;

import fun.deepsky.javamicroservice.user.domain.Entity;

public interface ReadOnlyRepository<TE,T> {

	boolean contains(T id);
	
	Entity get(T id);
	
	Collection<TE> getAll();
	
}
