DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE OF Balance;
    
    v_annual_fee NUMBER := 50;
    v_updated_count NUMBER := 0;
BEGIN
    FOR acc IN ApplyAnnualFee LOOP
        IF acc.Balance >= v_annual_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_annual_fee,
                LastModified = SYSDATE
            WHERE CURRENT OF ApplyAnnualFee;
            
            v_updated_count := v_updated_count + 1;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account ' || acc.AccountID || ' has insufficient funds for annual fee.');
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee applied to ' || v_updated_count || ' accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/