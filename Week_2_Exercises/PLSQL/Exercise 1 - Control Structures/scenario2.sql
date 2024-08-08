BEGIN
    BEGIN
        EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD IsVIP NUMBER(1) DEFAULT 0';
    EXCEPTION
        WHEN OTHERS THEN
            IF SQLCODE = -01430 THEN
                DBMS_OUTPUT.PUT_LINE('IsVIP column already exists');
            ELSE
                RAISE;
            END IF;
    END;

    UPDATE Customers
    SET IsVIP = CASE WHEN Balance > 10000 THEN 1 ELSE 0 END;

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' customers updated.');
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END;
/