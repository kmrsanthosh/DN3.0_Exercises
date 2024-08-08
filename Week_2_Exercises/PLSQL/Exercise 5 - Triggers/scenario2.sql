CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TableName VARCHAR2(50),
    Operation VARCHAR2(10),
    RecordID NUMBER,
    LogDate DATE,
    UserName VARCHAR2(30)
);

CREATE SEQUENCE AuditLog_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TableName, Operation, RecordID, LogDate, UserName)
    VALUES (AuditLog_seq.NEXTVAL, 'Transactions', 'INSERT', :NEW.TransactionID, SYSDATE, USER);
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (3, 1, SYSDATE, 150, 'Deposit');

SELECT * FROM AuditLog;