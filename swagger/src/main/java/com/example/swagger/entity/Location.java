package com.example.swagger.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "location_tb")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long location_id;
    @Column(name = "street_name", unique = true)
    private String street_name;
    @Column(name = "city")
    private String city;

//    @OneToMany(targetEntity = Employee.class, mappedBy = "location")
//    private List<Employee> employee;

    public Location(Long locationId, String streetName, String city) {
    }
}
