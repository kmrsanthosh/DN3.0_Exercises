package com.employeemanagementsystem.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.employee_management_system.entity.Department;

import java.util.List;

@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByNameContainingIgnoreCase(String name);

    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) = (SELECT MAX(SIZE(dept.employees)) FROM Department dept)")
    List<Department> findDepartmentsWithMostEmployees();

    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :count")
    List<Department> findDepartmentsWithEmployeeCountGreaterThan(@Param("count") int count);

    List<Department> findByEmployeeCountNamedQuery(@Param("count") int count);
}
