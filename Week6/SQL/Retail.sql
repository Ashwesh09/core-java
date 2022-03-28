CREATE DATABASE IF NOT EXISTS retail_business CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE retail_business;
CREATE TABLE 'customers'(
    'customerNumber' UNSIGNED int(11) NOT NULL AUTO_INCREMENT,
    'customerName' varchar(25) DEFAULT NULL,
    'contactLastName' varchar(25) DEFAULT NULL,
    'contactFirstName' varchar(25) DEFAULT NULL,
    'phone' varchar(10) DEFAULT NULL,
    'addressLine1' varchar(50) DEFAULT NULL,
    'addressLine2' varchar(50) DEFAULT NULL,
    'city' varchar(25) DEFAULT NULL,
    'state' varchar(25) DEFAULT NULL,
    'postalCode' varchar(6) DEFAULT NULL,
    'country' varchar(25) DEFAULT NULL,
    'salesRepEmployeeNumber' int(10) NOT NULL,
    'credLimit' varchar(50) NOT NULL,
    CONSTRAINT 'PK_customer' PRIMARY KEY ('customerNumber'),
    CONSTRAINT `CHK_customer_phone` CHECK(`phone` is null or `phone` regexp '^[0-9]{10}$'),
    CONSTRAINT `FK_employees_customer` FOREIGN KEY (`salesRepEmployeeNumber`) REFERENCES `employees` (`employeeNumber`),
    INDEX 'IX_customer_customerName' ('customerName'),
)ENGINE = InnoDB;

CREATE TABLE `employees`(
    'employeeNumber' UNSIGNED int(11) NOT NULL AUTO_INCREMENT,
    'lastName' varchar(25) DEFAULT NULL,
    'firstName' varchar(25) DEFAULT NULL,
    'extension' varchar(25) DEFAULT NULL,
    'email' varchar(25) DEFAULT NULL,
    'officeCode' UNSIGNED int(5) DEFAULT NULL,
    'reportsTo' varchar(25) DEFAULT NULL,
    'jobTitle' varchar(25) NOT NULL,
    CONSTRAINT `PK_employees` PRIMARY KEY ('employeeNumber'),
    CONSTRAINT `UQ_employees_email` UNIQUE ('email'),
    CONSTRAINT `FK_offices_employees` FOREIGN KEY (`officeCode`) REFERENCES `office` (`officeCode`),
    CONSTRAINT `FK_employees_employees` FOREIGN KEY (`reportsTo`) REFERENCES `employees`(`employeeNumber`),
    INDEX `IX_employees_email` (`email`)
)ENGINE=InnoDB;

CREATE TABLE `offices`(
    'officeCode' UNSIGNED int(11) DEFAULT NULL,
    'city' varchar(25) DEFAULT NULL,
    'phone' varchar(10) DEFAULT NULL,
    'addressLine1' varchar(50) DEFAULT NULL,
    'addressLine2' varchar(50) DEFAULT NULL,
    'state' varchar(25) DEFAULT NULL,
    'country' varchar(25) DEFAULT NULL,
    'postalCode' varchar(6) DEFAULT NULL,
    'territory' varchar(25) DEFAULT NULL,
    CONSTRAINT 'PK_offices' PRIMARY KEY ('officeCode'),
    CONSTRAINT `CHK_offices_phone` CHECK(`phone` is null or `phone` regexp '^[0-9]{10}$'),
    INDEX `IX_offices_postalCode` (`postalCode`)
)ENGINE = InnoDB;

CREATE TABLE `productlines`(
    'productLine' VARCHAR(25) NOT NULL,
    'textDescription' VARCHAR(255) DEFAULT NULL,
    'htmlDescription' VARCHAR(50),
    'image' VARCHAR(50) DEFAULT NULL,
    CONSTRAINT `PK_productLine` PRIMARY KEY (`productLine`),
)
 CREATE TABLE `product`(
     'productCode' int(11) NOT NULL,
     'productName' VARCHAR(255) DEFAULT NULL,
     'productLine' VARCHAR(50) DEFAULT NULL,
     'productScale' VARCHAR(50) DEFAULT NULL,
     'productVendor' VARCHAR(50) DEFAULT NULL,
     'productDescription' VARCHAR(255) DEFAULT NULL,
     'qunatityInStock' UNSIGNED int(5) DEFAULT NULL,
     'buyPrice' int(6) UNSIGNED DEFAULT NULL,
     'MSRP' int(6) UNSIGNED DEFAULT NULL,
     CONSTRAINT `PK_product` PRIMARY KEY (`productCode`),
     CONSTRAINT `FK_productLine_products` FOREIGN KEY (`productLine`) REFERENCES `productlines` (`productLine`),
     INDEX `IX_products_productName` (`productName`)
 )ENGINE=InnoDB;

 CREATE TABLE `orderdetails` (
     'orderNumber' int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
     'productCode' int(11) UNSIGNED DEFAULT NULL,
     'quantityOrdered' tinyint(2) UNSIGNED DEFAULT NULL,
     'priceEach' int(5) UNSIGNED DEFAULT NULL,
     'orderLineNumber' int(11) UNSIGNED DEFAULT NULL,
     CONSTRAINT `PK_orderDetails` PRIMARY KEY (`orderNumber`,`productCode`),
     CONSTRAINT `FK_orderDetails_productCode` FOREIGN KEY (`productCode`) REFERENCES `products` (`productCode`)
)ENGINE = InnoDB;

CREATE TABLE `orders` (
    `orderNumber` int(11) UNSIGNED NOT NULL,
    `orderDate` datetime NOT NULL,
    `requiredDate` datetime,
    `shippedDate` datetime NOT NULL,
    `status` enum('SHIPPED','DELIVERED','ORDER_CONFIRMED') NOT NULL,
    `comments` varchar(255) DEFAULT NULL,
    `customerNumber` int(11) UNSIGNED NOT NULL,
     CONSTRAINT `PK_orders` PRIMARY KEY (`orderNumber`),
     CONSTRAINT `FK_orderDetails_orders` FOREIGN KEY (`orderNumber`) REFERENCES `orderDetails` (`orderNumber`),
     CONSTRAINT `FK_customers_orders` FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`)
)ENGINE = InnoDB;

CREATE TABLE `payments`(
    `customerNumber` int(11) UNSIGNED NOT NULL,
    `checkNumber` int(11) UNSIGNED,
    `paymentDate` datetime NOT NULL,
    `amount` int(11) NOT NULL,
     CONSTRAINT `PK_payments` PRIMARY KEY (`customerNumber`, `checkNumber`),
     CONSTRAINT `UQ_payments_checkNumber` UNIQUE (`checkNumber`)
     CONSTRAINT `FK_customers_payments` FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`),
)ENGINE = InnoDB;
