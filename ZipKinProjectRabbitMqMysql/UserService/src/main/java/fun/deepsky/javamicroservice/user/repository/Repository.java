package fun.deepsky.javamicroservice.user.repository;

public interface Repository<TE,T> extends ReadOnlyRepository<TE, T>{

	void add(TE entity);
	
	void remove(T id);
	
	void update(TE entity);
	
}
