package controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import model.Cliente;
import model.Clientes;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseStatus
public class ControllerUsuario {

	@RequestMapping("/form")
	public String formulario() {
		return "formulario";
	}

	@RequestMapping("/listagemClientes")
	public ModelAndView listUsers() {
		String url = "http://localhost:8080/RestWs-JPA/cliente/allClientes";
		RestTemplate template = new RestTemplate();
		List<Cliente> clientes = template.getForObject(url, Clientes.class)
				.getClientes();
		return new ModelAndView("listaClientes", "clientes", clientes);
	}

	@RequestMapping("/form/{userid}")
	public ModelAndView dispUser(@PathVariable("userid") int userid) {
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/RestWs-JPA/cliente/{userid}";
		Cliente cliente = template.getForObject(url, Cliente.class, userid);
		return new ModelAndView("formulario", "cliente", cliente);
	}

	@RequestMapping("adicionarCliente")
	public String adiciona(@Valid Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			return "formulario";
		}
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/RestWs-JPA/cliente";
		template.postForObject(url, cliente, Cliente.class);
		return "redirect:/listagemClientes";
	}
	
	@RequestMapping("/removerCliente/{id}")
	public String removerCliente(@PathVariable("id") int id){
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/RestWs-JPA/cliente/{id}";
		template.delete(url, id);
		return "redirect:/listagemClientes";
	}
	
	
	@RequestMapping("/form/editarCliente/{id}")
	public String editarCliente(Cliente cliente, @PathVariable("id") int id) {
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/RestWs-JPA/cliente/editar/{id}";
		template.postForObject(url, cliente, Cliente.class, id);
		return "redirect:/listagemClientes";
	}
	

	
	

}
