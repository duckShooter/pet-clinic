package guru.framework.petclinic.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //Embeds the properties in each subclass table
public class BaseEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Some databases (e.g. Oracle 11g) don't support this strategy
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
