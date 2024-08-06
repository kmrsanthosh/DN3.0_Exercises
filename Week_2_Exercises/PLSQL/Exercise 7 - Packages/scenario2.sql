CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE hire_employee(
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );
    
    PROCEDURE update_employee(
        p_employee_id NUMBER,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );
    
    FUNCTION calculate_annual_salary(p_employee_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE hire_employee(
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (Employees_seq.NEXTVAL, p_name, p_position, p_salary, p_department, SYSDATE);
        COMMIT;
    END hire_employee;
    
    PROCEDURE update_employee(
        p_employee_id NUMBER,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employee_id;
        COMMIT;
    END update_employee;
    
    FUNCTION calculate_annual_salary(p_employee_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary * 12 INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;
        
        RETURN v_salary;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END calculate_annual_salary;
END EmployeeManagement;
/
