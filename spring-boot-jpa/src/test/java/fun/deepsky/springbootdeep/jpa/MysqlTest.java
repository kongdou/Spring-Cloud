package fun.deepsky.springbootdeep.jpa;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfiguration.class})
public class MysqlTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
     @Before
	public void initData() {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		departmentRepository.deleteAll();
		
		Department department = new Department();
		department.setName("开发部");
		departmentRepository.save(department);
		Assert.notNull(department.getId());
		
		Role role = new Role();
		role.setName("admin");
		roleRepository.save(role);
		Assert.notNull(role.getId());
		
		User user = new User();
		user.setName("user");
		user.setCreatedate(new Date());
		user.setDepartment(department);
		List<Role> roles = roleRepository.findAll();
		Assert.notNull(roles);
		user.setRoles(roles);
		
		userRepository.save(user);
		Assert.notNull(user.getId());
	}
     
     @Test
     public void findPage() {
	    	 Pageable pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));
	    	 Page<User> page = userRepository.findAll(pageable);
	    	 Assert.notNull(page);
	    	 for(User user:page.getContent()) {
	    		 System.out.println("=====user===== user name:"+user.getName()+"=====department name:"+user.getDepartment().getName()+"====="+user.getRoles().get(0).getName());
	    	 }
     }
}
