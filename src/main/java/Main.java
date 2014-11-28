import model.AnimalDao;
import model.ClienteDao;



public class Main {

	public static void main(String[] args) {
		AnimalDao animal = new AnimalDao();
		animal.criarTabelaAnimais();
		
		System.out.println("Tabela animais criada com sucesso!");
		ClienteDao cliente = new ClienteDao();
		cliente.criarTabelaClientes();
		System.out.println("Tabela clientes criada com sucesso!");
	}

}
