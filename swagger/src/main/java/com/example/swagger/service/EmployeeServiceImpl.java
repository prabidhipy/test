package com.example.swagger.service;

import com.example.swagger.dto.EmployeeDto;
import com.example.swagger.entity.Employee;
import com.example.swagger.mapper.EmployeeMapper;
import com.example.swagger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.get();

        //convert from jpa entity to dto
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert from dto to jpa entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee newEmployee = employeeRepository.save(employee);

        //convert from entity to dto
        EmployeeDto newEmployeeDto = EmployeeMapper.mapToEmployeeDto(newEmployee);

        return newEmployeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee updateEmployee = employeeRepository.findById(employeeDto.getEmpId()).get();
        updateEmployee.setName(employeeDto.getName());
        updateEmployee.setGender(employeeDto.getGender());
        updateEmployee.setJobTitle(employeeDto.getJobTitle());

        Employee changedEmpValue = employeeRepository.save(updateEmployee);

        return EmployeeMapper.mapToEmployeeDto(changedEmpValue);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
