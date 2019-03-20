package guru.framework.petclinic.services;

import java.util.Set;

import guru.framework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Integer> {	
	Set<Owner> findByLastName(String lastName);
}
