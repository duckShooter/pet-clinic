package guru.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.framework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Integer> {

}
