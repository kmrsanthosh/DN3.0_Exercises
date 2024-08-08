CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE open_account(
        p_customer_id NUMBER,
        p_account_type VARCHAR2,
        p_initial_balance NUMBER
    );
    
    PROCEDURE close_account(p_account_id NUMBER);
    
    FUNCTION get_total_balance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE open_account(
        p_customer_id NUMBER,
        p_account_type VARCHAR2,
        p_initial_balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (Accounts_seq.NEXTVAL, p_customer_id, p_account_type, p_initial_balance, SYSDATE);
        COMMIT;
    END open_account;
    
    PROCEDURE close_account(p_account_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;
        COMMIT;
    END close_account;
    
    FUNCTION get_total_balance(p_customer_id NUMBER) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;
        
        RETURN v_total_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END get_total_balance;
END AccountOperations;
/
