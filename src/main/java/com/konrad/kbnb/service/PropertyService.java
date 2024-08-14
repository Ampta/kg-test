package com.konrad.kbnb.service;

import com.konrad.kbnb.Model.PropertyRequestBody;
import com.konrad.kbnb.entity.Property;
import com.konrad.kbnb.repository.PropertyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return propertyRepo.save(property);
    }

    public List<Property> getPropertiesWithNameAndMinimumAmountOfStars(String name){
        return propertyRepo.getPropertyWithMinimumStars(name);
    }

}
