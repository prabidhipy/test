package com.example.swagger.mapper;

import com.example.swagger.dto.EmployeeDto;
import com.example.swagger.entity.Employee;

public interface EmployeeMapper {

    //converting jpa entity into dto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getEmpId(),
                employee.getName(),
                employee.getGender(),
                employee.getJobTitle(),
                employee.getLocation().getStreet_name(),
                employee.getLocation().getCity()
                );
        return employeeDto;
    }

    //converting dto to jpa entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getEmpId(),
                employeeDto.getName(),
                employeeDto.getGender(),
                employeeDto.getJobTitle()
        );
        return employee;
    }
}