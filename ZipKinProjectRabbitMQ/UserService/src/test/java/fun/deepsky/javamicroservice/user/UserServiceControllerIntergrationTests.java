package fun.deepsky.javamicroservice.user;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=UserServiceApp.class)
@WebIntegrationTest("server.port=0")
public class UserServiceControllerIntergrationTests {

	 private final RestTemplate restTemplate = new TestRestTemplate();
	 
	 public static final ObjectMapper objectMapper = new ObjectMapper();
	 
	 @Value("${local.server.port}")
	 private String port;
	 
	 @Test
	 public void testGetById() {
		 
		 Map<String, Object> result =  restTemplate.getForObject("http://localhost:"+port+"/UserService/user/1", Map.class);
		 Assert.assertNotNull(result);
		 String id = result.get("id").toString();
		 Assert.assertEquals("1",id);
		 
		 String name = result.get("name").toString();
		 Assert.assertEquals("User Name 1",name);
	 }
	 
	 /**
	     * Test the GET /v1/user/{id} API for no content
	     */
	    @Test
	    public void testGetById_NoContent() {

	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<Object> entity = new HttpEntity<>(headers);
	        ResponseEntity<Map> responseE = restTemplate.exchange("http://localhost:" + port + "/v1/user/99", HttpMethod.GET, entity, Map.class);

	        assertNotNull(responseE);

	        // Should return no content as there is no user with id 99
	        assertEquals(HttpStatus.NO_CONTENT, responseE.getStatusCode());
	    }

	    /**
	     * Test the GET /v1/user API
	     */
	    @Test
	    public void testGetByName() {

	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<Object> entity = new HttpEntity<>(headers);
	        Map<String, Object> uriVariables = new HashMap<>();
	        uriVariables.put("name", "User");
	        ResponseEntity<Map[]> responseE = restTemplate.exchange("http://localhost:" + port + "/UserService/user/?name={name}", HttpMethod.GET, entity, Map[].class, uriVariables);

	        assertNotNull(responseE);

	        // Should return no content as there is no user with id 99
	        assertEquals(HttpStatus.OK, responseE.getStatusCode());
	        Map<String, Object>[] responses = responseE.getBody();
	        assertNotNull(responses);

	        assertTrue(responses.length == 2);

	        Map<String, Object> response = responses[0];
	        String id = response.get("id").toString();
	        assertNotNull(id);
	        assertEquals("1", id);
	        String name = response.get("name").toString();
	        assertNotNull(name);
	        assertEquals("User Name 1", name);
	        boolean isModified = (boolean) response.get("isModified");
	        assertEquals(false, isModified);
	    }

	    /**
	     * Test the POST /v1/user API
	     *
	     * @throws JsonProcessingException
	     */
	    @Test
	    public void testAdd() throws JsonProcessingException {

	        Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("name", "Testusr 3");
	        requestBody.put("id", "3");
	        requestBody.put("address", "Address for 3rd User");
	        requestBody.put("city", "City");
	        requestBody.put("phoneNo", "9999933333");
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        objectMapper.findAndRegisterModules();
	        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(requestBody), headers);

	        ResponseEntity<Map> responseE = restTemplate.exchange("http://localhost:" + port + "/UserService/user", HttpMethod.POST, entity, Map.class, Collections.EMPTY_MAP);

	        assertNotNull(responseE);

	        // Should return created (status code 201)
	        assertEquals(HttpStatus.CREATED, responseE.getStatusCode());

	        //validating the newly created user using API call
	        Map<String, Object> response
	                = restTemplate.getForObject("http://localhost:" + port + "/UserService/user/3", Map.class);

	        assertNotNull(response);

	        //Asserting API Response
	        String id = response.get("id").toString();
	        assertNotNull(id);
	        assertEquals("3", id);
	        String name = response.get("name").toString();
	        assertNotNull(name);
	        assertEquals("Testusr 3", name);
	        boolean isModified = (boolean) response.get("isModified");
	        assertEquals(false, isModified);
	        String address = response.get("address").toString();
	        assertNotNull(address);
	        assertEquals("Address for 3rd User", address);
	        String city = response.get("city").toString();
	        assertNotNull(city);
	        assertEquals("City", city);
	        String phoneNo = response.get("phoneNo").toString();
	        assertNotNull(phoneNo);
	        assertEquals("9999933333", phoneNo);
	    }
	
}