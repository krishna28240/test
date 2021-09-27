package com.example.employee.service;

import com.example.employee.error.EmployeeNotFoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(String employeeNumber) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findByEmployeeNumber(employeeNumber);
        if (employeeEntity.isPresent()) {
            return mapEmployee(employeeEntity.get());
        }
        throw new EmployeeNotFoundException("Employee not found for employeeNumber:" + employeeNumber);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList=new ArrayList<>();
        List<EmployeeEntity> employees = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity :employees) {
            employeeList.add(mapEmployee(employeeEntity));
        }
        return employeeList;
    }
    @Override
    public int updateEmployee(Employee employee) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findByEmployeeNumber(employee.getUserId());
        if (employeeEntity.isPresent()) { ;
            return employeeRepository.updateEmployee(employee.getFirstName(), employee.getLastName(), employee.getUserId());
        }else{
            throw new EmployeeNotFoundException("Employee not found for employeeNumber:" + employee.getUserId());
        }
    }

    @Override
    public List<Employee> findByFirstnameOrLastname(String firstName, String lastName) {
        List<Employee> employeeList=new ArrayList<>();
        List<EmployeeEntity> employeeEntity=employeeRepository.findByFirstnameOrLastname(firstName, lastName);
        if(!employeeEntity.isEmpty()) {
            for (EmployeeEntity employeeEntity1 : employeeEntity) {
                employeeList.add(mapEmployee(employeeEntity1));
            }
        }else{
            throw new EmployeeNotFoundException("Employee not found either by firstName or lastName:" + firstName +" / "+ lastName);
        }
        return employeeList;

    }

    private Employee mapEmployee(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getEmployeeNumber(), employeeEntity.getFirstname(), employeeEntity.getLastname());
    }
}
