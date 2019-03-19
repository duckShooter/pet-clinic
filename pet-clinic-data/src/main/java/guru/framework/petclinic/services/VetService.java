package guru.framework.petclinic.services;

import java.util.Set;

import guru.framework.petclinic.model.Vet;

public interface VetService {
	Vet findById(Long id);
	Set<Vet> findAll();
	Vet save(Vet vet);
}
