package guru.framework.petclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Speciality;
import guru.framework.petclinic.repositories.SpecialityRepository;
import guru.framework.petclinic.services.SpecialityService;

@Service
@Profile("jpa")
public class SpecialityJpaService implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialityJpaService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}
	
	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> Specialities = new HashSet<>();
		specialityRepository.findAll().forEach(Specialities::add);
		return Specialities;
	}

	@Override
	public Speciality findById(Integer id) {
		return specialityRepository.findById(id).orElse(null); //returns null if the Speciality wasn't found
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Integer id) {
		specialityRepository.deleteById(id);
	}
}
