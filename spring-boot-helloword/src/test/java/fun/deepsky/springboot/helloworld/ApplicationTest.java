package fun.deepsky.springboot.helloworld;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class ApplicationTest {

	private MockMvc mockMvc;
    
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new Application()).build();
	}
	
	@Test
	public void testIndex() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		Assert.assertTrue(status==200);
		Assert.assertTrue("内容一致", content.equals("hello world"));
	}
}
