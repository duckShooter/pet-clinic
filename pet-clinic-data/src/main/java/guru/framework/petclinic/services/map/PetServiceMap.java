package guru.framework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Pet;
import guru.framework.petclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Integer> implements PetService {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Integer id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}

}
