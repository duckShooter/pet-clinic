package guru.framework.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.framework.petclinic.model.Owner;

class OwnerMapServiceTest {

	private final Integer ownerId = 1;
	private final String lastName = "smith";
	private OwnerMapService ownerMapService;
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		Owner owner = new Owner();
		owner.setId(ownerId);
		owner.setLastName("smith");
		ownerMapService.save(owner);
	}


	@Test
	void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdInteger_whenExist() {
		Owner owner = ownerMapService.findById(ownerId);
		assertNotNull(owner);
		assertEquals(owner.getId(), ownerId);
	}
	
	@Test
	void testFindByIdInteger_whenNotExist() {
		Owner owner = ownerMapService.findById(100);
		assertNull(owner);
	}
	
	@Test
	void testDeleteByIdInteger() {
		ownerMapService.deleteById(ownerId);
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void testDeleteOwner() {
		Owner owner = ownerMapService.findById(ownerId);
		ownerMapService.delete(owner);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testSaveOwner_withIdSpecified() {
		final int id = 2;
		Owner owner2 = new Owner();
		owner2.setId(id); //Id provided
		Owner ownerSaved = ownerMapService.save(owner2);
		
		assertEquals(id, ownerSaved.getId());
	}
	
	@Test
	void testSaveOwner_withNoIdSpecified() {
		Owner owner2 = new Owner();
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void testFindByLastName_whenExist() {
		Owner owner2 = new Owner();
		owner2.setId(2);
		owner2.setLastName(lastName);
		ownerMapService.save(owner2);
		
		Set<Owner> owners = ownerMapService.findByLastName(lastName);
		
		assertEquals(2, owners.size());
		owners.forEach(owner -> assertEquals(lastName, owner.getLastName()));
	}
	
	@Test
	void testFindByLastName_whenNotExist() {
		Set<Owner> owner = ownerMapService.findByLastName("randomName");
		assertEquals(0, owner.size());
	}
}
