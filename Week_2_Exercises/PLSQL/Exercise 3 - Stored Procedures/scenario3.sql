CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
) AS
    v_from_balance NUMBER;
    v_insufficient_funds EXCEPTION;
    PRAGMA EXCEPTION_INIT(v_insufficient_funds, -20001);
BEGIN
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
    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
EXCEPTION
    WHEN v_insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs are invalid.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error transferring funds: ' || SQLERRM);
END TransferFunds;
/