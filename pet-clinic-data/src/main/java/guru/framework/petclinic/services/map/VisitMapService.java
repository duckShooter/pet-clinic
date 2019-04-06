package guru.framework.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Visit;
import guru.framework.petclinic.services.PetService;
import guru.framework.petclinic.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Integer> implements VisitService {
	
	private final PetService petService;
	
	public VisitMapService(PetService petService) {
		this.petService = petService;
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Integer id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		if(object != null) {
			if(object.getPet() != null) 
				if(object.getPet().getId() == null)
					petService.save(object.getPet());
			else
				throw new RuntimeException("Pet is required");
			return super.save(object);
		}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}
}
