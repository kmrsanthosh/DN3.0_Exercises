CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
)
IS
    v_from_balance NUMBER;
    v_insufficient_funds EXCEPTION;
    PRAGMA EXCEPTION_INIT(v_insufficient_funds, -20001);
BEGIN
    SAVEPOINT start_transfer;

    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        RAISE v_insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_from_account, SYSDATE, -p_amount, 'Transfer');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_to_account, SYSDATE, p_amount, 'Transfer');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');

EXCEPTION
    WHEN v_insufficient_funds THEN
        ROLLBACK TO start_transfer;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
    WHEN NO_DATA_FOUND THEN
        ROLLBACK TO start_transfer;
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs are invalid.');
    WHEN OTHERS THEN
        ROLLBACK TO start_transfer;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/