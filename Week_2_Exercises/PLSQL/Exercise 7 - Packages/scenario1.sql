CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE add_customer(
        p_name VARCHAR2,
        p_dob DATE,
        p_initial_balance NUMBER
    );
    
    PROCEDURE update_customer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE
    );
    
    FUNCTION get_customer_balance(p_customer_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE add_customer(
        p_name VARCHAR2,
        p_dob DATE,
        p_initial_balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (Customers_seq.NEXTVAL, p_name, p_dob, p_initial_balance, SYSDATE);
        COMMIT;
    END add_customer;
    
    PROCEDURE update_customer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;
        COMMIT;
    END update_customer;
    
    FUNCTION get_customer_balance(p_customer_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;
        
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END get_customer_balance;
END CustomerManagement;
/
