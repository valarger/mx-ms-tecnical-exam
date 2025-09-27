package com.invex.business;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.invex.dto.Employee;
import com.invex.repositories.EmployeeRepository;
import com.invex.services.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() 
            -> new com.invex.exceptions.ResourceNotFoundException("Employee not found with id: " + id)));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() 
            -> new com.invex.exceptions.ResourceNotFoundException("Employee not found by id: " + id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setMiddleName(employee.getMiddleName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setMothersLastName(employee.getMothersLastName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setActive(employee.isActive());
        return employeeRepository.save(existingEmployee);
    }
}
