package com.example.employee.service;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(String employeeNumber);
    List<Employee> getEmployees();
    int updateEmployee(Employee employee);
    List<Employee> findByFirstnameOrLastname(String firstName, String lastName);
}
