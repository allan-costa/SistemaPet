package model;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@ApplicationScoped
public class ClienteService {
	
	@ManagedProperty(value="#{clienteDao}")
	private ClienteDao clienteDao = new ClienteDao();

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void alterar(Cliente cliente) {
		System.out.println("NOME==>" + cliente.getNome());
		System.out.println("NOME==>" + cliente.getId());
		clienteDao.alterar(cliente);
	}
	
	public void salvar(Cliente cliente) {
		clienteDao.incluirCliente(cliente);
	}

	public List<Cliente> obterClientes() {
		return clienteDao.getClientes();
	}

	public void excluir(Cliente cliente) {
		clienteDao.excluir(cliente);
	}

}
