package com.example.swagger.service;

import com.example.swagger.dto.LocationDto;
import com.example.swagger.entity.Location;

import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocations();
    LocationDto findById(Long id);
    LocationDto saveLocation(LocationDto locationDto);
    LocationDto updateLocation(LocationDto locationDto);
    void deleteLocation(Long id);
}
