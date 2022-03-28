
DELIMITER //

CREATE PROCEDURE isPrime(IN x INT(11),
    OUT outputIs INT
)
BEGIN
    SET outputIs = 1;
    IF x < 2 THEN
        SET outputIs = 0;
    ELSE
        SET @i = x - 1;
        WHILE @i >= 2
        DO
            IF(x mod @i = 0) THEN
                SET outputIs = 0;
            END IF;
        SET @i = @i - 1;
        END WHILE;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE printDivisor(IN x INT(11))
BEGIN
    DECLARE i INT;
    DECLARE str VARCHAR(255) DEFAULT '';

    SET i = 1;
    WHILE (i <= x)
    DO
        IF (x mod i = 0) THEN
            SET str = CONCAT(str,i, ', ');
        END IF;
        SET i = i + 1;
    END WHILE;
    SELECT str;
END //

DELIMITER ;

DELIMITER // 
CREATE PROCEDURE mainProcess(
    IN x INT(11)
)
BEGIN
    SET @temp = x;
    CALL isPrime(@temp,@outputIs);
    IF (@outputIs = 1) THEN
        WHILE @temp <> 1 DO
            SET @temp = @temp - 1;
            SET x = x * (@temp);
        END WHILE;
        SELECT x;
    ELSE
        CALL printDivisor(@temp);
    END IF;
END//

DELIMITER ;

CALL mainProcess(5);

DELIMITER //
CREATE PROCEDURE isPalindrome(IN num INT(11), OUT str VARCHAR(5)
)
BEGIN
    DECLARE temp VARCHAR(20);
    DECLARE rev VARCHAR(20);
    SET temp = num;
    SET rev = '';
    WHILE (num > 0) 
    DO
        SET rev = CONCAT(rev,num mod 10);
        SET num = num / 10;
    END WHILE;
    IF rev = temp THEN
        SET str = "YES";
    ELSE
        SET str = "NO";
    END IF;
END//

DELIMITER ;

call isPalindrome(141,@ans);
Select @ans;
call isPalindrome(123,@ans);
Select @ans;