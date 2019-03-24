package guru.framework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Integer> implements OwnerService {
	
	/*We must add the 'public' modifier, because we can't reduce the visibility of the inherited methods
	  Removing the 'public' modifier will make the methods 'package private' which reduces the visibility to the outer package */
	@Override
	public void delete(Owner object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
	
	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public Owner findById(Integer id) {
		return super.findById(id);
	}
	
	@Override
	public Owner save(Owner object) {
		return super.save(object);
	}
	
	@Override
	public Set<Owner> findByLastName(String lastName) {
		return null;
	}
	
}
