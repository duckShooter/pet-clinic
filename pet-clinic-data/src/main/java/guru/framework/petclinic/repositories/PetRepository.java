package guru.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.framework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {

}
