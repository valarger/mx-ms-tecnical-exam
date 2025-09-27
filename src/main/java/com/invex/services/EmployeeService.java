package com.invex.services;

import java.util.List;
import java.util.Optional;
import com.invex.dto.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    void deleteById(Long id);
    List<Employee> findByName(String name);
    Employee update(Long id, Employee employee);
}
