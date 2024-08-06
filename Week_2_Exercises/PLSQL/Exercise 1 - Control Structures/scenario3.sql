DECLARE
    v_reminder_date DATE := SYSDATE + 30;
BEGIN
    FOR loan_rec IN (SELECT c.CustomerID, c.Name, l.LoanID, l.EndDate
                     FROM Customers c
                     JOIN Loans l ON c.CustomerID = l.CustomerID
                     WHERE l.EndDate <= v_reminder_date
                     AND l.EndDate > SYSDATE)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan_rec.Name || ' (Customer ID: ' || loan_rec.CustomerID || '),');
        DBMS_OUTPUT.PUT_LINE('Your loan (Loan ID: ' || loan_rec.LoanID || ') is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD') || '.');
        DBMS_OUTPUT.PUT_LINE('Please make arrangements for repayment.');
        DBMS_OUTPUT.PUT_LINE('--------------------');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Reminder process completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/