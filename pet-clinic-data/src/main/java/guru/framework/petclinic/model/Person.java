package guru.framework.petclinic.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass //Embeds the properties in each subclass table
public class Person extends BaseEntity {
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
