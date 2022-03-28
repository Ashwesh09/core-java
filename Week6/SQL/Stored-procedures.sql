use org;

DELIMITER //

CREATE FUNCTION computeTax(Salary int)
RETURNS Decimal(10,2)
DETERMINISTIC
BEGIN
    DECLARE tax Decimal(10,2);
    IF Salary <= 75000 THEN
        SET tax = salary * 0.1 ;
    ELSEIF Salary >= 75000 AND Salary <= 150000 THEN
        SET tax = salary * 0.2;
    ELSE 
        SET tax = salary * 0.3;
    END IF;
    RETURN tax;
END //

Select worker_id,salary,computeTax(salary) as IncomeTax from worker;


DELIMITER //

CREATE PROCEDURE calculatedIncomeTax(
    IN sal INT,
    OUT incomeTax DECIMAL(10,2)
)
BEGIN 
    SELECT computeTax(sal) INTO incomeTax;
END //

DELIMITER ;