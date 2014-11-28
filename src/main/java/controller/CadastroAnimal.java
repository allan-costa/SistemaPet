package controller;

import java.util.List;

import model.Animal;
import model.AnimalService;

public class CadastroAnimal {
	
	private AnimalService animalService = new AnimalService();
	private Animal animal = new Animal();

	//Para fazer "cache" e ganhar desempenho.
	private List<Animal> animais;

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public List<Animal> getAnimais() {
		//Implementação de "cache" da lista de clientes.
		if (animais == null) {
			animais = animalService.obterAnimais();
		}
		return animais;
	}

	public String salvar() {
		animalService.salvar(animal);
		
		return "cadastro-animal?faces-redirect=true";
	}
	
	public String excluir(Animal animal) {
		animalService.excluir(animal);
		return "cadastro-animal?faces-redirect=true";
	}
	
	public String alterar(Animal animal) {
		animalService.excluir(animal);
		return "listagem?faces-redirect=true";
	}

}
