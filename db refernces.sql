DROP DATABASE  IF EXISTS `customer_security_dcrypt`;
CREATE DATABASE  IF NOT EXISTS `customer_security_dcrypt`;
USE `customer_security_dcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$1wZElg6iXaZH4VBGgLNvreNLT/6bzFEm3EB888Ayn18NlwKX4n1.q',1),
('mary','{bcrypt}$2a$10$sPeGF5h8lShchzEL9D7uiedSHRMwlJcPTPGZH0DPKNmXGsS4aKqrq',1),
('susan','{bcrypt}$2a$10$oUp9Nb10Jd2AAif44N4zOOek.rHTpUt/silO5HU4YHszJdEBl17IS',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `authorities` 
VALUES 
('john','ROLE_CUSTOMER'),
('mary','ROLE_CUSTOMER'),
('mary','ROLE_MANAGER'),
('susan','ROLE_CUSTOMER'),
('susan','ROLE_ADMIN');