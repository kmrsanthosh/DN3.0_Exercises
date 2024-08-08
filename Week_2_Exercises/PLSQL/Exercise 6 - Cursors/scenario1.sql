DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID, c.Name, a.AccountID, a.AccountType, 
               t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.CustomerID, t.TransactionDate;
    
    v_prev_customer_id NUMBER := -1;
    v_total_balance NUMBER := 0;
BEGIN
    FOR stmt IN GenerateMonthlyStatements LOOP
        IF stmt.CustomerID != v_prev_customer_id THEN
            IF v_prev_customer_id != -1 THEN
                DBMS_OUTPUT.PUT_LINE('Total Balance: $' || v_total_balance);
                DBMS_OUTPUT.PUT_LINE('----------------------------------------');
            END IF;
            DBMS_OUTPUT.PUT_LINE('Monthly Statement for ' || stmt.Name);
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || stmt.CustomerID);
            DBMS_OUTPUT.PUT_LINE('----------------------------------------');
            DBMS_OUTPUT.PUT_LINE('Date       | Account | Type   | Amount');
            DBMS_OUTPUT.PUT_LINE('----------------------------------------');
            v_total_balance := 0;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE(
            RPAD(TO_CHAR(stmt.TransactionDate, 'YYYY-MM-DD'), 11) || '| ' ||
            RPAD(stmt.AccountType, 8) || '| ' ||
            RPAD(stmt.TransactionType, 7) || '| $' ||
            TO_CHAR(stmt.Amount, '999990.00')
        );
        
        IF stmt.TransactionType = 'Deposit' THEN
            v_total_balance := v_total_balance + stmt.Amount;
        ELSE
            v_total_balance := v_total_balance - stmt.Amount;
        END IF;
        
        v_prev_customer_id := stmt.CustomerID;
    END LOOP;
    
    IF v_prev_customer_id != -1 THEN
        DBMS_OUTPUT.PUT_LINE('Total Balance: $' || v_total_balance);
        DBMS_OUTPUT.PUT_LINE('----------------------------------------');
    END IF;
END;
/