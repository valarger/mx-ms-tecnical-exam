package com.invex.businessTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.invex.business.EmployeeServiceImpl;
import com.invex.dto.Employee;
import com.invex.repositories.EmployeeRepository;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Gerardo");
    }

    @Test
    void findAll() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        List<Employee> employees = employeeService.findAll();
        assertEquals(1, employees.size());
    }

    @Test
    void findById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> employeeOptional = employeeService.findById(1L);
        assertEquals("Gerardo", employeeOptional.get().getFirstName());
    }

    @Test
    void save() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee savedEmployee = employeeService.save(employee);
        assertEquals("Gerardo", savedEmployee.getFirstName());
    }
}
