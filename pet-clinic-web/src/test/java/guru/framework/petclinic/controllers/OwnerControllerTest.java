package guru.framework.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.framework.petclinic.model.Owner;
import guru.framework.petclinic.services.OwnerService;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> dummyOwners;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		dummyOwners = new HashSet<Owner>();
		Owner owner = new Owner();
		owner.setId(12);
		dummyOwners.add(owner);
		owner = new Owner();
		owner.setId(13);
		dummyOwners.add(owner);
		
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(dummyOwners);
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("owners", hasSize(2)))
			.andExpect(view().name("owners/index"));
		verify(ownerService).findAll();
	}
	
	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("under-construction"));
		verifyZeroInteractions(ownerService);
	}
}
