package test;

import java.util.LinkedHashMap;
import java.util.List;

import model.Cliente;
import model.Clientes;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class Teste {
	
	
	@Test
	public void test(){
		RestTemplate restTemplate = new  RestTemplate();
		ResponseEntity<Cliente[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/planningpokerWS/cliente/users/", 
		Cliente[].class);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		List<Cliente> clientes = restTemplate.getForObject("http://localhost:8080/planningpokerWS/cliente/allusers/", Clientes.class).getClientes();
		System.out.println(clientes.toString());
		System.out.println(responseEntity);
	}
	


}
