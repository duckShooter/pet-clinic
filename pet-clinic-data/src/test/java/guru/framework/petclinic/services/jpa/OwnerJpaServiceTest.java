package guru.framework.petclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
	
	@Mock
	private OwnerRepository ownerRepository;
	
	@InjectMocks
	private OwnerJpaService service;
	
	private Owner returnOwner;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = new Owner();
		returnOwner.setFirstName("John");
		returnOwner.setLastName("Smith");
	}


	@Test
	void testFindAll() {
		Set<Owner> allOwners = new HashSet<>();
		allOwners.add(returnOwner);
		allOwners.add(new Owner());
		
		when(ownerRepository.findAll()).thenReturn(allOwners);
		
		assertNotNull(service.findAll());
		assertEquals(2, service.findAll().size());
	}

	@Test
	void testFindById_whenExist() {
		when(ownerRepository.findById(anyInt())).thenReturn(Optional.of(returnOwner));
		assertNotNull(service.findById(1));
		verify(ownerRepository).findById(anyInt());
	}
	
	@Test
	void testFindById_whenNotExist() {
		when(ownerRepository.findById(anyInt())).thenReturn(Optional.empty());
		assertNull(service.findById(1));
		verify(ownerRepository).findById(anyInt());
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner savedOwner = service.save(new Owner());
		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any());

	}

	@Test
	void testDeleteById() {
		service.deleteById(1);
		verify(ownerRepository).deleteById(anyInt());
	}

	@Test
	void testFindByLastName() {
		final String lastName = "Smith";
		Set<Owner> ownersByLastName = new HashSet<>();
		ownersByLastName.add(returnOwner);
		
		when(ownerRepository.findByLastName(anyString())).thenReturn(ownersByLastName);
		
		service.findByLastName(lastName).forEach(o -> 
			assertEquals(lastName, o.getLastName()));
		verify(ownerRepository).findByLastName(anyString());
	}
}
