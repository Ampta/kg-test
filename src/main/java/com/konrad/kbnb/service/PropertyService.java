package com.konrad.kbnb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.konrad.kbnb.Model.LookUpTreeNode;
import com.konrad.kbnb.Model.PropertyRequestBody;
import com.konrad.kbnb.entity.Property;
import com.konrad.kbnb.exception.RestrictedPropertyException;
import com.konrad.kbnb.repository.PropertyRepo;

import jakarta.transaction.Transactional;

@Service
public class PropertyService {

    private final PropertyRepo propertyRepo;

    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public Property getProperty(long id){
        Property property = propertyRepo.findById(id);
        return property;
    }

    public Property addProperty(PropertyRequestBody propertyBody){
        Property property = Property.propertyFromDto(propertyBody);
        return propertyRepo.save(property);
    }

    public Property getFakeProperty(String name){
        Property property = propertyRepo.getFakeProperty(name);
        if(property.getName().equals("restricted"))throw new RestrictedPropertyException("restricted");
        if(property.getName().equals("name"))property.setName("Put in a real name");
        return property;
    }

    public List<Property> getPropertiesWithNameAndMinimumAmountOfStars(String name, int stars){
        return propertyRepo.getPropertyWithMinimumStars(name, stars);
    }

    public List<Long> getSuperHost(){
        return List.of();
    }

    public LookUpTreeNode getLookUpTree(){
        return new LookUpTreeNode();
    }
    
    public List<Property> getPropertyByName(String propertyName){
    	if(propertyName == null || propertyName.isEmpty()) {
    		return propertyRepo.findAll();
    	}
    	return propertyRepo.getPropertyByName(propertyName);
    }
    
    @Transactional
    public void deletePropertyById(Long id) {
    	propertyRepo.deletePropertyById(id);
    }
}
