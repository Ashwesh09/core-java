use hr;

DELIMITER //
CREATE PROCEDURE getAllEmployees() 
    BEGIN
    SELECT concat(firstname,' ',lastname),city,state,country from employees inner join offices using (officecode);
    END //
DELIMITER ;

CALL getAllEmployees();




DELIMITER //
CREATE PROCEDURE getpayments()  
 BEGIN
 SELECT customername,checknumber,paymentdate,amount from customers inner join payments using (customernumber); 
 END //

delimiter ;
CALL getpayments();


DROP PROCEDURE getAllEmployees;

DROP PROCEDURE getPayments;