package guru.framework.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.model.Pet;
import guru.framework.petclinic.model.PetType;
import guru.framework.petclinic.model.Speciality;
import guru.framework.petclinic.model.Vet;
import guru.framework.petclinic.services.OwnerService;
import guru.framework.petclinic.services.PetTypeService;
import guru.framework.petclinic.services.SpecialityService;
import guru.framework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService, SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		loadData();
	}

	private void loadData() {
		PetType dogPetType = new PetType();
		dogPetType.setName("Dog");
		petTypeService.save(dogPetType);
		
		PetType catPetType = new PetType();
		catPetType.setName("Cat");
		petTypeService.save(dogPetType);
		
		Speciality radiology = new Speciality();
		radiology.setName("Radilology");
		specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setName("Surgery");
		specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setName("Dentistry");
		specialityService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Alex");
		owner1.setLastName("Mercer");
		owner1.setAddress("121 Buriedalive");
		owner1.setCity("Los Santos");
		owner1.setPhone("+20455569874");
		ownerService.save(owner1);
		
		Pet alexPet = new Pet();
		alexPet.setBirthDate(LocalDate.now());
		alexPet.setOwner(owner1);
		alexPet.setPetType(dogPetType);
		alexPet.setName("Osiris");
		owner1.getPets().add(alexPet);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("James");
		owner2.setLastName("Heller");
		owner2.setAddress("122 Buriedalive");
		owner2.setCity("Los Santos");
		owner2.setPhone("+20877441119");
		ownerService.save(owner2);
		
		Pet jamesPet = new Pet();
		jamesPet.setBirthDate(LocalDate.now());
		jamesPet.setPetType(catPetType);
		jamesPet.setName("Tommy");
		jamesPet.setOwner(owner2);
		owner2.getPets().add(jamesPet);
		
		System.out.println("Loaded Owners ... ");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("John");
		vet1.setLastName("Wick");
		vet1.getSpecialities().add(surgery);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Rose");
		vet2.setLastName("Washington");
		vet2.getSpecialities().add(dentistry);
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ...");
	}
}
