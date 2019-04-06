package guru.framework.petclinic.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import guru.framework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	Set<Owner> findByLastName(String lastName); //Query method
}
