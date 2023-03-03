package com.example.swagger.resource;

import com.example.swagger.dto.EmployeeDto;
import com.example.swagger.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/employee")
@Api(value = "Employee" ,tags = "Employee Management",description = "Manages Employees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation(value = "This method is to find all the registered employees.")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees(){
        List<EmployeeDto> employeeDto = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is to find the registered employee based on their ID.")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto = employeeService.findById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "This method is to register a new employee.")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto newEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This method is to update an employee record.")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        employeeDto.setEmpId(id);
        EmployeeDto updateEmployee = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "This method is to delete an employee based on their ID.")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
