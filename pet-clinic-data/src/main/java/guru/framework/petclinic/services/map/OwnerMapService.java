package guru.framework.petclinic.services.map;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.services.OwnerService;
import guru.framework.petclinic.services.PetService;
import guru.framework.petclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Integer> implements OwnerService {
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

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
		if(object != null) {
			if(!object.getPets().isEmpty()) { //If the owner has pets
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) //Check if the pets are assigned a type
						if(pet.getPetType().getId() == null) //Check if the pet type isn't persisted
							petTypeService.save(pet.getPetType()); //persist it
					else
						throw new RuntimeException("Pet type is required");
					if(pet.getId() == null) //Check if pet is not persisted (based on ID auto-generation on persistence)
						petService.save(pet);
				});
			}
			return super.save(object);			
		}
		return null;
	}
	
	@Override
	public Set<Owner> findByLastName(String lastName) {
		Set<Owner> ownerWithLastName = new HashSet<>();
		map.values().forEach(owner -> {
			if(owner.getLastName().equalsIgnoreCase(lastName))
				ownerWithLastName.add(owner);
		});
		return ownerWithLastName;
	}
}
