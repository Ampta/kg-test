package com.konrad.kbnb.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.konrad.kbnb.entity.Property;

public interface PropertyRepo extends Repository<Property, Long> {
    Property findById(Long id);
    Property save(Property property);
    List<Property> findAll();
    Property getFakeProperty(String propertyName);
    List<Property> getPropertyWithMinimumStars(String propertyName, int stars);
    
    List<Property> getPropertyByName(String name);
    void deletePropertyById(Long id);
}
