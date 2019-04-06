package guru.framework.petclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.repositories.OwnerRepository;
import guru.framework.petclinic.services.OwnerService;

@Service
@Profile("jpa")
public class OwnerJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	
	public OwnerJpaService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Integer id) {
		return ownerRepository.findById(id).orElse(null); //returns null if the owner wasn't found
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Integer id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Set<Owner> findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
