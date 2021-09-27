package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("v/1.0/")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("employee/{employeeNumber}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeNumber") String employeeNumber) {
        Employee employee = employeeService.getEmployee(employeeNumber);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employee = employeeService.getEmployees();
        if (!employee.isEmpty()) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        int isEmployeeUpdated = employeeService.updateEmployee(employee);
        if (isEmployeeUpdated == 1) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("employee/firstName/{firstName}/lastName/{lastName}")
    public ResponseEntity<List<Employee>> getEmployee(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        List<Employee> employees = employeeService.findByFirstnameOrLastname(firstName, lastName);
        if (!employees.isEmpty() ) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
