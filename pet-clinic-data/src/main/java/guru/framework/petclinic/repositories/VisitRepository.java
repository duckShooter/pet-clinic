package guru.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.framework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Integer> {

}
