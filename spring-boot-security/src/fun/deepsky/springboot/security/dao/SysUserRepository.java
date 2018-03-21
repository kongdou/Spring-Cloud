package fun.deepsky.springboot.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fun.deepsky.springboot.security.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

	SysUser findByUsername(String username);
}
