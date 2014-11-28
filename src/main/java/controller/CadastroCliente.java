package controller;

import java.io.Serializable;
import java.util.List;






import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import model.Cliente;
import model.ClienteService;


public class CadastroCliente implements Serializable {

	private ClienteService clienteService = new ClienteService();
	private Cliente cliente = new Cliente();
	

	//Para fazer "cache" e ganhar desempenho.
	private List<Cliente> clientes;
	
	
	
	public void setclienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	public List<Cliente> getClientes() {
		//Implementação de "cache" da lista de clientes.
		if (clientes == null) {
			clientes = clienteService.obterClientes();
		}
		return clientes;
	}
	
	public String alterar() {
		clienteService.alterar(cliente);
		return "cadastro-cliente?faces-redirect=true";
	
	}
	
	public String salvar() {
		clienteService.salvar(cliente);
		return "cadastro-cliente?faces-redirect=true";
	
	}
	
	public String excluir(Cliente cliente) {
		clienteService.excluir(cliente);
		return "cadastro-cliente?faces-redirect=true";
	}
	
	//
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Dados Alterados", ((Cliente) event.getObject()).getNome());
        
        cliente = ((Cliente) event.getObject());
        
        clienteService.alterar(cliente);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Cliente) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}

