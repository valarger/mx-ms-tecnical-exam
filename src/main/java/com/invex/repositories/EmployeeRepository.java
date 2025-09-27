package com.invex.repositories;

import java.util.List;
import java.util.Optional;
import com.invex.dto.Employee;

public interface EmployeeRepository {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    void deleteById(Long id);
    List<Employee> findByName(String name);
}
