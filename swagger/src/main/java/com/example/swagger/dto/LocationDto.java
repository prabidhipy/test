package com.example.swagger.dto;

import com.example.swagger.entity.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    @ApiModelProperty(notes = "Location id of employee(s)")
    private Long location_id;
    @ApiModelProperty(notes = "Street name of the employee(s)")
    private String street_name;
    @ApiModelProperty(notes="City the employee(s) belong to")
    private String city;

//    @ApiModelProperty(notes="Name of the employees registered here")
//    private List<String> name;
}
