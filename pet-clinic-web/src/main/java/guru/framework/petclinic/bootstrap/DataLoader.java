package guru.framework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.model.Vet;
import guru.framework.petclinic.services.OwnerService;
import guru.framework.petclinic.services.VetService;
import guru.framework.petclinic.services.map.OwnerServiceMap;
import guru.framework.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setId(1);
		owner1.setFirstName("Alex");
		owner1.setLastName("Mercer");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2);
		owner2.setFirstName("James");
		owner2.setLastName("Heller");
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners ... ");
		
		Vet vet1 = new Vet();
		vet1.setId(1);
		vet1.setFirstName("John");
		vet1.setLastName("Wick");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2);
		vet2.setFirstName("Rose");
		vet2.setLastName("Washington");
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ...");
	}

}
