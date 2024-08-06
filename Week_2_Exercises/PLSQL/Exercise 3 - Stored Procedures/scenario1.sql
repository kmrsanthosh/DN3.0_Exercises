CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_interest_rate NUMBER := 0.01; 
BEGIN
    UPDATE Accounts a
    SET Balance = Balance * (1 + v_interest_rate),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    SELECT Transactions_seq.NEXTVAL, AccountID, SYSDATE, Balance * v_interest_rate, 'Interest'
    FROM Accounts
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/