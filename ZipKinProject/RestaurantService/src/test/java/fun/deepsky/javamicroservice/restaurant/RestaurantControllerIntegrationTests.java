package fun.deepsky.javamicroservice.restaurant;

import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fun.deepsky.javamicroservice.restaurant.domain.Table;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=RestaurantServiceApp.class)
@WebIntegrationTest("server.port=0")//使用0表示端口号生成随机
public class RestaurantControllerIntegrationTests extends AbstractRestaurantControllerTests{

	RestTemplate restTemplate = new TestRestTemplate();
	
	//注入端口号
	@Value("${local.server.port}")
	private int port;
	
	@Test
	public void testGetById() {
		
		Map<String,Object> response = restTemplate.getForObject("http://localhost:"+port+"/RestaurantService/restaurants/1", Map.class);
		   Assert.assertNotNull(response);

	        String id = response.get("id").toString();
	        Assert.assertNotNull(id);
	        Assert.assertEquals("1", id);
	        String name = response.get("name").toString();
	        Assert.assertNotNull(name);
	        Assert.assertEquals("Le Meurice", name);
	        boolean isModified = (boolean) response.get("isModified");
	        Assert.assertEquals(false, isModified);
	        List<Table> tableList = (List<Table>) response.get("tables");
	        Assert.assertNull(tableList);
	}
	
	@Test
	public void testGetById_NoContent() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<HttpHeaders> requestEntity = new HttpEntity<HttpHeaders>(headers);
		ResponseEntity<Map> responseE = restTemplate.exchange("http://localhost:"+port+"/RestaurantService/restaurants/1", HttpMethod.GET, requestEntity, Map.class);
		Assert.assertNotNull(responseE);
		Assert.assertEquals(HttpStatus.OK,responseE.getStatusCode());
	}
	
	
	@Test
    public void testGetByName() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<HttpHeaders> requestEntity = new HttpEntity<HttpHeaders>(headers);
		Map<String, Object> vars = new HashMap<>();
		vars.put("name", "Meurice");
		ResponseEntity<Map[]> responseE = restTemplate.exchange("http://localhost:"+port+"/RestaurantService/restaurants?name={name}", HttpMethod.GET, requestEntity, Map[].class,vars);
		Assert.assertNotNull(responseE);
		Assert.assertEquals(HttpStatus.OK, responseE.getStatusCode());
		
		Map[] response = responseE.getBody();
		Assert.assertNotNull(response);
		
		Assert.assertTrue(response.length == 1);
		
	}
	
	@Test
	public void testAdd() throws JsonProcessingException {
		
		 Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("name", "La Plaza Restaurant");
	        requestBody.put("id", "11");
	        requestBody.put("address", "address of La Plaza Restaurant");
	        
	        Map<String, Object> table1 = new HashMap<>();
	        table1.put("name", "Table 1");
	        table1.put("id", BigInteger.ONE);
	        table1.put("capacity", Integer.valueOf(6));
	        Map<String, Object> table2 = new HashMap<>();
	        table2.put("name", "Table 2");
	        table2.put("id", BigInteger.valueOf(2));
	        table2.put("capacity", Integer.valueOf(4));
	        Map<String, Object> table3 = new HashMap<>();
	        table3.put("name", "Table 3");
	        table3.put("id", BigInteger.valueOf(3));
	        table3.put("capacity", Integer.valueOf(2));
	        List<Map<String, Object>> tableList = new ArrayList();
	        tableList.add(table1);
	        tableList.add(table2);
	        tableList.add(table3);
	        requestBody.put("tables", tableList);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<String> requestEntity = new HttpEntity<>(new ObjectMapper().writeValueAsString(requestBody),headers); 
	        ResponseEntity<Map> responseE = restTemplate.exchange("http://localhost:"+port+"/RestaurantService/restaurants", HttpMethod.POST, requestEntity,Map.class,Collections.EMPTY_MAP);
	        Assert.assertNotNull(responseE);
	        // Should return created (status code 201)
	        Assert.assertEquals(HttpStatus.CREATED, responseE.getStatusCode());
	}
}
