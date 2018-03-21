package fun.deepsky.javamicroservice.restaurant.repository;

import java.util.Collection;


import fun.deepsky.javamicroservice.restaurant.domain.Entity;

public interface ReadOnlyRepository<TE,T> {

	boolean contains();
	
	Entity get(T id);
	
	Collection<TE> getAll();
}
