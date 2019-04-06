package guru.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.framework.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Integer> {

}
