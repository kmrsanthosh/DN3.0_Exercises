package com.employeemanagementsystem.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.employee_management_system.entity.Department;

import java.util.Optional;

@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    boolean existsByName(String name);

    long countEmployeesById(Long id);
}
