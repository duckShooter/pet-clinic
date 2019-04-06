package guru.framework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Vet;
import guru.framework.petclinic.services.SpecialityService;
import guru.framework.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Integer> implements VetService {
	
	private final SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
	
	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Integer id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if(object != null) {
			if(!object.getSpecialities().isEmpty())
				object.getSpecialities().forEach(speciality -> {
					if(speciality.getId() == null)
						specialityService.save(speciality);
				});
		}else 
			return null;
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
}
