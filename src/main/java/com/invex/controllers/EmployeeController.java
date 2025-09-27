package com.invex.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.invex.constants.ConstantsApi;
import com.invex.dto.Employee;
import com.invex.exceptions.ResourceNotFoundException;
import com.invex.services.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(ConstantsApi.BASE_PATH)
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(ConstantsApi.ID_FIND)
    public ResponseEntity<Employee> getEmployeeById(
        @PathVariable Long id) {
        Employee employee = employeeService.findById(id).orElseThrow(() 
            -> new ResourceNotFoundException("Employee not found with id: " + id));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
        @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping(ConstantsApi.ID_FIND)
    public ResponseEntity<Employee> updateEmployee(
        @PathVariable Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.OK);
    }

    @DeleteMapping(ConstantsApi.ID_FIND)
    public ResponseEntity<Void> deleteEmployee(
        @PathVariable Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(ConstantsApi.SEARCH_API)
    public ResponseEntity<List<Employee>> searchEmployeeByName(
        @RequestParam String name) {
        return new ResponseEntity<>(employeeService.findByName(name), HttpStatus.OK);
    }
}

