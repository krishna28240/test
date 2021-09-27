package com.example.employee.repository;

import com.example.employee.model.Employee;
import com.example.employee.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmployeeNumber(String employeeNumber);
    @Modifying
    @Query("UPDATE EmployeeEntity e SET e.firstname = :firstName, e.lastname = :lastName WHERE e.employeeNumber = :employeeNo")
    int updateEmployee(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("employeeNo") String employeeNo);
    List<EmployeeEntity> findByFirstnameOrLastname(String firstName, String lastName);
}
