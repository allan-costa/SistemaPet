package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import model.Cliente;
import model.ClienteService;

public class ClientesMB implements Serializable {
	 
	 private Map<String,Integer> clientes = new HashMap<String, Integer>(16);
	 
	 private ClienteService clienteService = new ClienteService();
	 private List<Cliente> clientesList = clienteService.obterClientes();;
	   
	    
	   @PostConstruct
	   public void init() {
		    for(Cliente c : clientesList) {  
		        clientes.put(c.getNome(), c.getId());
		      }  
	   	
	   }

	   public Map<String, Integer> getClientes() {
	       return clientes;
	   }

}
