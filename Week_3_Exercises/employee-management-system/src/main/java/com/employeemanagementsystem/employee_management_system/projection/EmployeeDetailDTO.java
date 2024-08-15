package com.employeemanagementsystem.employee_management_system.projection;

public class EmployeeDetailDTO {
    private final String name;
    private final String email;
    private final Double salary;
    private final String departmentName;

    public EmployeeDetailDTO(String name, String email, Double salary, String departmentName) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
