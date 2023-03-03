package com.example.swagger.mapper;

import com.example.swagger.dto.LocationDto;
import com.example.swagger.entity.Location;

public interface LocationMapper {
    //converting jpa entity to dto
    public static LocationDto mapToLocationDto(Location location){
        LocationDto locationDto = new LocationDto(
                location.getLocation_id(),
                location.getStreet_name(),
                location.getCity()
        );
        return locationDto;
    }

    //converting dto to jpa entity
    public static Location mapToLocation(LocationDto locationDto){
        Location location = new Location(
                locationDto.getLocation_id(),
                locationDto.getStreet_name(),
                locationDto.getCity()
        );
        return location;
    }
}
