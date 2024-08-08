CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error calculating age: ' || SQLERRM);
        RETURN NULL;
END CalculateAge;
/

DECLARE
    v_customer_age NUMBER;
BEGIN
    SELECT CalculateAge(DOB) INTO v_customer_age
    FROM Customers
    WHERE CustomerID = 1;
    
    DBMS_OUTPUT.PUT_LINE('Customer age: ' || v_customer_age);
END;
/