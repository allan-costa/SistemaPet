package model;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@ApplicationScoped
public class AnimalService {
	
	@ManagedProperty(value="#{animalDao}")
	private AnimalDao animalDao = new AnimalDao();

	public void setAnimalDao(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}

	public List<Animal> obterAnimais() {
		return animalDao.getAnimais();
		
	}

	public void salvar(Animal animal) {
		animalDao.incluirAnimal(animal);
		
	}

	public void excluir(Animal animal) {
		animalDao.excluir(animal);
		
	}


	
	

}
