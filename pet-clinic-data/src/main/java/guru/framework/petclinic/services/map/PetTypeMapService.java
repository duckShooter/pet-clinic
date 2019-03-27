package guru.framework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.PetType;
import guru.framework.petclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Integer> implements PetTypeService {
	
	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}
	
	@Override
	public PetType findById(Integer id) {
		return super.findById(id);
	}
	
	@Override
    public void delete(PetType object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
	
	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}
}
