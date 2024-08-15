package com.employeemanagementsystem.employee_management_system.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    String getName();

    String getEmail();

    @Value("#{target.department.name}")
    String getDepartmentName();
}
