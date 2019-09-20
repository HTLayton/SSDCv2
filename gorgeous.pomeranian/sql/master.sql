-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssdc
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ssdc` ;

-- -----------------------------------------------------
-- Schema ssdc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssdc` DEFAULT CHARACTER SET utf8 ;
USE `ssdc` ;

-- -----------------------------------------------------
-- Table `ssdc`.`table1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssdc`.`account` ;

CREATE TABLE IF NOT EXISTS `ssdc`.`account` (
  `email` VARCHAR(50) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password_hash` VARCHAR(64) NOT NULL,
  `log_on_status` TINYINT(4) NOT NULL DEFAULT 0,
  `verified` TINYINT(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS ssdc_main;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'ssdc_main'@'localhost' IDENTIFIED BY 'y50Tc2M1@a7jNhf';
GRANT ALL PRIVILEGES ON ssdc.* TO 'ssdc_main'@'localhost';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
