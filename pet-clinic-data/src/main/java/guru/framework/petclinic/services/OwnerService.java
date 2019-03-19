package guru.framework.petclinic.services;

import java.util.Set;

import guru.framework.petclinic.model.Owner;

public interface OwnerService {	
	Owner findById(Integer id);
	Set<Owner> findAll();
	Set<Owner> findByLastName(String lastName);
	Owner save(Owner owner);
}
