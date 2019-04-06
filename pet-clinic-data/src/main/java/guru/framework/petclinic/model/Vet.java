package guru.framework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Vet extends Person {
	private Set<Speciality> specialities = new HashSet<>();

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
}
