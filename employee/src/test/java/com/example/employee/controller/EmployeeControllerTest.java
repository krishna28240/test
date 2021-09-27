package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService service;

    @Test
    public void shouldGetEmployeeForTheGivenEmployeeId() {
        String employeeNumber = "001003";
        Employee employee = new Employee(employeeNumber, "firstname", "lastname");
        when(service.getEmployee(employeeNumber)).thenReturn(employee);
        ResponseEntity<Employee> employeeResponseEntity = this.employeeController.getEmployee(employeeNumber);
        assertEquals(HttpStatus.OK, employeeResponseEntity.getStatusCode());
        assertEquals(employee, employeeResponseEntity.getBody());
    }

    @Test
    public void shouldGetEmployeeNotFoundException() {
        String employeeNumber = "001001";
        when(service.getEmployee(employeeNumber)).thenReturn(null);
        ResponseEntity<Employee> employeeResponseEntity = this.employeeController.getEmployee(employeeNumber);
        assertEquals(HttpStatus.NOT_FOUND, employeeResponseEntity.getStatusCode());
    }
}
