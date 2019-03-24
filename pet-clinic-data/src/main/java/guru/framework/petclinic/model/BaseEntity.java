package guru.framework.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
