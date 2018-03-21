package fun.deepsky.javamicroservice.book.repository;

import java.util.Collection;

import fun.deepsky.javamicroservice.book.domain.Entity;

public interface ReadOnlyRepository<TE,T> {

	boolean contains(T id);
	
	Entity get(T id);
	
	Collection<TE> getAll();
}
