DECLARE
    v_age NUMBER;
BEGIN
    FOR customer_rec IN (SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
                         FROM Customers c
                         JOIN Loans l ON c.CustomerID = l.CustomerID)
    LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to loan for customer ' || customer_rec.CustomerID);
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount application process completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END;
/