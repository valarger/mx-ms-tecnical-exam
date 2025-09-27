package com.invex.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.invex.dto.Employee;
import com.invex.model.DeleteByIdQuery;
import com.invex.model.InsertIntoEmployeesCommand;
import com.invex.model.SelectAllEmployees;
import com.invex.model.SelectByIdQuery;
import com.invex.model.SelectFindEmployeesQuery;
import com.invex.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    private Employee mapRowToEmployee(ResultSet rs, int rowNum) throws SQLException {
      try{
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setMiddleName(rs.getString("second_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setMothersLastName(rs.getString("second_last_name"));
        employee.setAge(rs.getInt("age"));
        employee.setGender(rs.getString("gender"));
        employee.setDateOfBirth(rs.getDate("date_burn").toLocalDate());
        employee.setPosition(rs.getString("job"));
        employee.setDateOfStartInSystem(rs.getTimestamp("date_start").toLocalDateTime());
        employee.setActive(rs.getBoolean("state"));
        return employee;
      } catch (Exception e) {
        throw new SQLException("Unexpected error during query executions: {}", e);
    }
    }

    @Override
    public List<Employee> findAll() {
      String sqlAll = SelectAllEmployees.read();
        return jdbcTemplate.query(sqlAll, this::mapRowToEmployee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        String sqlById = SelectByIdQuery.read();
        return jdbcTemplate.query(sqlById, this::mapRowToEmployee, id).stream().findFirst();
    }

    @Override
    public Employee save(Employee employee) {
        String sqlInsert = InsertIntoEmployeesCommand.read();
        jdbcTemplate.update(sqlInsert, employee.getFirstName(), employee.getMiddleName(), employee.getLastName(),
                employee.getMothersLastName(), employee.getAge(), employee.getGender(), employee.getDateOfBirth(),
                employee.getPosition(), employee.isActive());
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = DeleteByIdQuery.read();
        jdbcTemplate.update(sqlDelete, id);
    }

    @Override
    public List<Employee> findByName(String name) {
        String sqlFindEmployee = SelectFindEmployeesQuery.read();
        return jdbcTemplate.query(sqlFindEmployee, this::mapRowToEmployee, "%" + name + "%");
    }
}
