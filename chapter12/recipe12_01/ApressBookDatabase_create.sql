DROP DATABASE IF EXISTS `apressBooks`;
CREATE DATABASE `apressBooks`;
CREATE TABLE `apressBooks`.`recipes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recipe_number` varchar(10) NOT NULL,
  `recipe_name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
 
insert into apressBooks.recipes values(1, 
'12-1',
'Installing MySQL',
'Downloading and installation of a MySQL Database'); 
 
insert into apressBooks.recipes values(2, 
'12-2',
'Connecting to a Database',
'DriverManager and DataSource Implementations');

insert into apressBooks.recipes values(3,
'12-3',
'Handling SQL Exceptions',
'Using SQLException');

insert into apressBooks.recipes values(4,
'12-4',
'Querying a Database and Retrieving Results',
'Obtaining and using data from a DBMS');

CREATE TABLE `apressBooks`.`publication` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_title` varchar(500) NOT NULL,
  `publish_date` date DEFAULT NULL,
  `publish_co` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into apressBooks.publication values (
1,
'Java 17 Recipes',
date('2021-12-01'),
'APRESS');

insert into apressBooks.publication values (
2,
'Beginning Jakarta EE Web Development',
date('2021-04-03'),
'APRESS');
