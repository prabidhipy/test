package com.example.swagger.resource;

import com.example.swagger.dto.LocationDto;
import com.example.swagger.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/location")
@Api(value = "Locations", tags = "Location Management", description = "Manages Locations")
public class LocationController {
    @Autowired
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    @ApiOperation(value = "This method will return all the locations that have been registered.")
    public ResponseEntity<List<LocationDto>> getAllLocations(){
        List<LocationDto> locationDto = locationService.getAllLocations();
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method will return location based on id")
    public ResponseEntity<LocationDto> findLocationById(@PathVariable("id") Long id){
        LocationDto locationDto = locationService.findById(id);
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "This method is to register a new location.")
    public ResponseEntity<LocationDto> saveLocation(@RequestBody LocationDto locationDto){
        LocationDto newLocation = locationService.saveLocation(locationDto);
        return new ResponseEntity<>(newLocation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This method is to update a location record.")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable("id") Long id, @RequestBody LocationDto locationDto){
        locationDto.setLocation_id(id);
        LocationDto updateLocation = locationService.updateLocation(locationDto);
        return new ResponseEntity<>(updateLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "This method is to delete any location based on id")
    public void deleteLocation(@PathVariable("id") Long id){
        locationService.deleteLocation(id);
    }
}
