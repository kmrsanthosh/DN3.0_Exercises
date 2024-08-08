CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_account_balance NUMBER;
BEGIN
    SELECT Balance INTO v_account_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > v_account_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
        END IF;
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        UPDATE Accounts SET Balance = Balance - :NEW.Amount WHERE AccountID = :NEW.AccountID;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        UPDATE Accounts SET Balance = Balance + :NEW.Amount WHERE AccountID = :NEW.AccountID;
    END IF;
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (4, 1, SYSDATE, 100, 'Withdrawal');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5, 1, SYSDATE, 10000, 'Withdrawal');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (7, 1, SYSDATE, -50, 'Deposit');

SELECT AccountID, Balance FROM Accounts WHERE AccountID = 1;