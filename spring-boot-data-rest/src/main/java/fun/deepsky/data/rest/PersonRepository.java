package fun.deepsky.data.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="people")
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	/**
	 * 访问路径
	 * http://localhost:8080/api/person/search/nameStartsWith?name=xxx
	 * @param name
	 * @return
	 */
	@RestResource(path="nameStartsWith",rel="nameStartsWith")
	Person findByNameStartsWith(@Param("name") String name);
	
	
}
