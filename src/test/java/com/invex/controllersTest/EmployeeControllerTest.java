package com.invex.controllersTest;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.invex.controllers.EmployeeController;
import com.invex.dto.Employee;
import com.invex.services.EmployeeService;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Gerardo");
    }

    @Test
    void getAllEmployees() {
        when(employeeService.findAll()).thenReturn(Arrays.asList(employee));
        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void getEmployeeById() {
        when(employeeService.findById(1L)).thenReturn(Optional.of(employee));
        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Gerardo", response.getBody().getFirstName());
    }

    @Test
    void createEmployee() {
        when(employeeService.save(employee)).thenReturn(employee);
        ResponseEntity<Employee> response = employeeController.createEmployee(employee);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Gerardo", response.getBody().getFirstName());
    }
}
