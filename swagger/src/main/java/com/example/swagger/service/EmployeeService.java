package com.example.swagger.service;

import com.example.swagger.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAllEmployees();
    EmployeeDto findById(Long id);
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
