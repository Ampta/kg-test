package com.konrad.kbnb.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.kbnb.Model.GenericResponse;
import com.konrad.kbnb.Model.LookUpTreeNode;
import com.konrad.kbnb.Model.PropertyRequestBody;
import com.konrad.kbnb.entity.Property;
import com.konrad.kbnb.service.PropertyService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/property")
public class PropertyControllerV1 {

    private final PropertyService propertyService;

    public PropertyControllerV1(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<Property>> getPropertyById(@PathVariable("id") long id) {
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.getProperty(id)));
    }

    @GetMapping("/fake")
    public ResponseEntity<GenericResponse<Property>> getFakePropertyById(@RequestParam("name") String name) {
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.getFakeProperty(name)));
    }

    @GetMapping("/minstars")
    public ResponseEntity<GenericResponse<List<Property>>> getPropertiesWithMinimumStars(@RequestParam("name") String name, @RequestParam("stars") int stars) {
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.getPropertiesWithNameAndMinimumAmountOfStars(name, stars)));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<Property>> addProperty(@RequestBody @Valid PropertyRequestBody propertyBody) {
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.addProperty(propertyBody)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Long id) {
    	propertyService.deletePropertyById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public ResponseEntity<GenericResponse<List<Property>>> getPropertyByName(@RequestParam(value="name", required=false) String name) {
        //TODO:
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.getPropertyByName(name)));
    }

    @GetMapping("/page/{pageNum}")
    public ResponseEntity<GenericResponse<List<Property>>> getPropertyPage() {
        //TODO:
        return ResponseEntity.ok(new GenericResponse<>(null, List.of(new Property())));
    }

    @GetMapping("/superhost")
    public ResponseEntity<GenericResponse<List<Long>>> getSuperHosts(){
        //TODO: get super hosts from properties
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.getSuperHost()));
    }

    @GetMapping("/lookuptree")
    public ResponseEntity<GenericResponse<LookUpTreeNode>> getPropertyLookupTree(){
        //TODO: get Property look up tree
        return ResponseEntity.ok(new GenericResponse<>(null, propertyService.getLookUpTree()));
    }
}
