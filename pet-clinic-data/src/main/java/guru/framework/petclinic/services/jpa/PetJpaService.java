package guru.framework.petclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Pet;
import guru.framework.petclinic.repositories.PetRepository;
import guru.framework.petclinic.services.PetService;

@Service
@Profile("jpa")
public class PetJpaService implements PetService {

	private final PetRepository petRepository;
	
	public PetJpaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Integer id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Integer id) {
		petRepository.deleteById(id);
	}
}
