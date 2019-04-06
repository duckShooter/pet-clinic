package guru.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.framework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Integer> {

}
