DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans
        FOR UPDATE OF InterestRate;
    
    v_new_rate NUMBER;
    v_updated_count NUMBER := 0;
    
    FUNCTION CalculateNewRate(p_loan_amount NUMBER, p_current_rate NUMBER) RETURN NUMBER IS
    BEGIN
        IF p_loan_amount < 10000 THEN
            RETURN p_current_rate + 0.5;
        ELSIF p_loan_amount >= 50000 THEN
            RETURN p_current_rate - 0.5;
        ELSE
            RETURN p_current_rate;
        END IF;
    END CalculateNewRate;
    
BEGIN
    FOR loan IN UpdateLoanInterestRates LOOP
        v_new_rate := CalculateNewRate(loan.LoanAmount, loan.InterestRate);
        
        IF v_new_rate != loan.InterestRate THEN
            UPDATE Loans
            SET InterestRate = v_new_rate
            WHERE CURRENT OF UpdateLoanInterestRates;
            
            v_updated_count := v_updated_count + 1;
            
            DBMS_OUTPUT.PUT_LINE('Loan ' || loan.LoanID || ' updated. Old rate: ' || 
                                 loan.InterestRate || '%, New rate: ' || v_new_rate || '%');
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rates updated for ' || v_updated_count || ' loans.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/