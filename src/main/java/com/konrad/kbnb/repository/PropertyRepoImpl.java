package com.konrad.kbnb.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.konrad.kbnb.entity.Property;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class PropertyRepoImpl{
    @PersistenceContext
    private EntityManager entityManager;

    public Property getFakeProperty(String propertyName){
        Property property = new Property();
        property.setName(propertyName);
        return property;
    }

    public List<Property> getPropertyWithMinimumStars(String propertyName, int stars){
        return entityManager.createQuery("select p from Property p where p.stars < 5", Property.class).getResultList();
    }
    
    public List<Property> getPropertyByName(String propertyName){
    	return entityManager.createQuery("select p FROM Property p where lower(p.name) like lower(concat(:name, '%'))", Property.class)
    			.setParameter("name", propertyName)
    			.getResultList();
    }
    
    
    public void deleteProperty(Long id) {
    	Property property = entityManager.find(Property.class, id);
    	entityManager.remove(property);
    }
    

}


