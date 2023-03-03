package com.example.swagger.service;

import com.example.swagger.dto.EmployeeDto;
import com.example.swagger.dto.LocationDto;
import com.example.swagger.entity.Employee;
import com.example.swagger.entity.Location;
import com.example.swagger.mapper.EmployeeMapper;
import com.example.swagger.mapper.LocationMapper;
import com.example.swagger.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    public final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(LocationMapper::mapToLocationDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto findById(Long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        Location location = optionalLocation.get();

        //convert entity to dto
        return LocationMapper.mapToLocationDto(location);
    }

    @Override
    public LocationDto saveLocation(LocationDto locationDto) {
        //convert from dto to jpa entity
        Location location = LocationMapper.mapToLocation(locationDto);

        Location newLocation = locationRepository.save(location);

        //convert from entity to dto
        LocationDto newLocationDto = LocationMapper.mapToLocationDto(newLocation);

        return newLocationDto;
    }

    @Override
    public LocationDto updateLocation(LocationDto locationDto) {
        Location updateLocation= locationRepository.findById(locationDto.getLocation_id()).get();
        updateLocation.setStreet_name(locationDto.getStreet_name());
        updateLocation.setCity(locationDto.getCity());

        Location changedLocValue = locationRepository.save(updateLocation);

        return LocationMapper.mapToLocationDto(changedLocValue);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
