package guru.framework.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import guru.framework.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Integer> {
	protected Map<Integer, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		if(object != null) {
			if(object.getId() == null) 
				object.setId(getNextId());
			map.put(object.getId(), object);
		} else 
			throw new NullPointerException();		
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		//Anonymous class implementing Predicate<T> interface using lambda expression
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Integer getNextId() {
		Integer nextId = null;
		try {
			nextId = Collections.max(map.keySet()) + 1;			
		} catch (NoSuchElementException e) {
			nextId = 1;
		}
		return nextId;
	}
}
