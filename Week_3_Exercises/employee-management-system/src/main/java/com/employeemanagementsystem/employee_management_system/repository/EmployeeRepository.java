package com.employeemanagementsystem.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.employee_management_system.entity.Employee;

import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find an employee by email
    Optional<Employee> findByEmail(String email);

    // Find all employees in a specific department
    List<Employee> findByDepartmentName(String departmentName);

    // Find employees whose name contains the given string (case-insensitive)
    List<Employee> findByNameContainingIgnoreCase(String name);
}
