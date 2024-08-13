package com.employeemanagementsystem.employee_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.employee_management_system.entity.Employee;
import com.employeemanagementsystem.employee_management_system.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> getEmployeesByDepartment(String departmentName, Pageable pageable) {
        return employeeRepository.findByDepartmentName(departmentName, pageable);
    }

    public Page<Employee> getEmployeesBySalaryRange(Double minSalary, Double maxSalary, Pageable pageable) {
        return employeeRepository.findBySalaryBetween(minSalary, maxSalary, pageable);
    }

    public Page<Employee> searchEmployeesByName(String name, Pageable pageable) {
        return employeeRepository.searchByName(name, pageable);
    }

}
