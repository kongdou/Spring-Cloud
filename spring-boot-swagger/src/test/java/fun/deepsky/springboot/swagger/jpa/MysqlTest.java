package fun.deepsky.springboot.swagger.jpa;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import fun.deepsky.springboot.swagger.jpa.User;
import fun.deepsky.springboot.swagger.jpa.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class MysqlTest {

	@Autowired
	UserRepository userRepository;
	
     @Before
	public void initData() {
		userRepository.deleteAll();
		
		User user = new User();
		user.setName("user");
		user.setCreatedate(new Date());
		userRepository.save(user);
		Assert.notNull(user.getId());
	}
     
     @Test
     public void findPage() {
	    	 Pageable pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));
	    	 Page<User> page = userRepository.findAll(pageable);
	    	 Assert.notNull(page);
	    	 for(User user:page.getContent()) {
	    		 System.out.println("=====user===== user name:"+user.getName()+"=====department name:");
	    	 }
     }
}
