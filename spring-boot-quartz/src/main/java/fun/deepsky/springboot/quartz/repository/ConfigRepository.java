package fun.deepsky.springboot.quartz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fun.deepsky.springboot.quartz.entity.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

}
