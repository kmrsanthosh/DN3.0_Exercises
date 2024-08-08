CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_interest_rate NUMBER,
    p_loan_duration_years NUMBER
)
RETURN NUMBER
IS
    v_monthly_rate NUMBER;
    v_num_payments NUMBER;
    v_monthly_installment NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 100 / 12;
    v_num_payments := p_loan_duration_years * 12;
    
    v_monthly_installment := p_loan_amount * (v_monthly_rate * POWER(1 + v_monthly_rate, v_num_payments)) 
                             / (POWER(1 + v_monthly_rate, v_num_payments) - 1);
    
    RETURN ROUND(v_monthly_installment, 2);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error calculating monthly installment: ' || SQLERRM);
        RETURN NULL;
END CalculateMonthlyInstallment;
/

DECLARE
    v_monthly_payment NUMBER;
BEGIN
    v_monthly_payment := CalculateMonthlyInstallment(100000, 5, 30);
    DBMS_OUTPUT.PUT_LINE('Monthly payment for a $100,000 loan at 5% interest for 30 years: $' || v_monthly_payment);
END;
/