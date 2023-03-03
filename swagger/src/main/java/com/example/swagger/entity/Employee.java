package com.example.swagger.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee_tb")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "name")
    @ApiModelProperty(notes = "Name of the employee", example = "John", required = true, position = 1)
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "job_title")
    @NotEmpty(message = "Job title is required")
    private String jobTitle;

    //many employees may have the same location
    @JoinColumn(name = "location_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Location location;

    public Employee(Long empId, String name, String gender, String jobTitle) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }
}
