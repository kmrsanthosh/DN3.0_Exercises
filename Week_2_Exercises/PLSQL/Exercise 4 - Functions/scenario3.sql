CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;
    
    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Account not found');
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error checking balance: ' || SQLERRM);
        RETURN FALSE;
END HasSufficientBalance;
/

DECLARE
    v_has_balance BOOLEAN;
BEGIN
    v_has_balance := HasSufficientBalance(1, 500);
    IF v_has_balance THEN
        DBMS_OUTPUT.PUT_LINE('Account has sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account does not have sufficient balance');
    END IF;
END;
/