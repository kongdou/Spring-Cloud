package fun.deepsky.springboot.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fun.deepsky.springboot.security.dao.SysUserRepository;
import fun.deepsky.springboot.security.domain.SysUser;

public class CustomUserService implements UserDetailsService {

	@Autowired
	SysUserRepository sysUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		SysUser user = sysUserRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}

}
