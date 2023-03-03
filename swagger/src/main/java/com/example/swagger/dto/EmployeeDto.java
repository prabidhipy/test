package com.example.swagger.dto;

import com.example.swagger.entity.Location;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @ApiModelProperty(notes = "User id of the employee")
    private Long empId;

    @ApiModelProperty(notes = "Name of the employee", example = "John", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "The employee's gender")
    private String gender;

    @ApiModelProperty(notes = "Job Title of the Employee")
    private String jobTitle;

//    @ApiModelProperty(notes = "Location id of the employee's location")
//    private Long location_id;

    @ApiModelProperty(notes = "The street the employee resides in")
    private String street_name;

    @ApiModelProperty(name="City the employee is from")
    private String city;

    public EmployeeDto(Long empId, String name, String gender, String jobTitle, Long locationId, String streetName, String city) {
    }
}
