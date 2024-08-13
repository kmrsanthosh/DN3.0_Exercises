package com.employeemanagementsystem.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeemanagementsystem.employee_management_system.entity.Employee;
import com.employeemanagementsystem.employee_management_system.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeService.getEmployeeById(id)
                .map(employee -> {
                    employee.setName(employeeDetails.getName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setDepartment(employeeDetails.getDepartment());
                    return ResponseEntity.ok(employeeService.saveEmployee(employee));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> {
                    employeeService.deleteEmployee(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paged")
    public Page<Employee> getAllEmployeesPaged(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return employeeService.getAllEmployees(pageable);
    }

    @GetMapping("/search")
    public Page<Employee> searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String departmentName,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {

        if (name != null && !name.isEmpty()) {
            return employeeService.searchEmployeesByName(name, pageable);
        } else if (departmentName != null && !departmentName.isEmpty()) {
            return employeeService.getEmployeesByDepartment(departmentName, pageable);
        } else if (minSalary != null && maxSalary != null) {
            return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary, pageable);
        } else {
            return employeeService.getAllEmployees(pageable);
        }
    }

}
