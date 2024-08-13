package com.employeemanagementsystem.employee_management_system.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.employee_management_system.entity.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByHireDateAfter(LocalDate date);

    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);

    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(emp.salary) FROM Employee emp)")
    List<Employee> findEmployeesWithSalaryAboveAverage();

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName AND e.hireDate > :hireDate")
    List<Employee> findEmployeesByDepartmentAndHireDate(@Param("departmentName") String departmentName,
            @Param("hireDate") LocalDate hireDate);

    List<Employee> findByDepartmentNamedQuery(@Param("departmentName") String departmentName);

    Long countByDepartmentNamedQuery(@Param("departmentName") String departmentName);

    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    Page<Employee> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    Page<Employee> searchByName(@Param("name") String name, Pageable pageable);

}
