package guru.framework.petclinic.services;

import java.util.Set;

import guru.framework.petclinic.model.Pet;

public interface PetService {
	Pet findById(Long id);
	Set<Pet> findAll();
	Pet save(Pet pet);
}
