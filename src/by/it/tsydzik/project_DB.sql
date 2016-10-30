-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tsydzik
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tsydzik
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tsydzik` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `tsydzik` ;

-- -----------------------------------------------------
-- Table `tsydzik`.`renter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsydzik`.`renter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tsydzik`.`auto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsydzik`.`auto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  `manufacture_date` INT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `engine_power` DOUBLE NOT NULL,
  `renter_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_auto_renter_idx` (`renter_id` ASC),
  CONSTRAINT `fk_auto_renter`
    FOREIGN KEY (`renter_id`)
    REFERENCES `tsydzik`.`renter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tsydzik`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsydzik`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tsydzik`.`rent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsydzik`.`rent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  `client_id` INT NOT NULL,
  `auto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rent_client1_idx` (`client_id` ASC),
  INDEX `fk_rent_auto1_idx` (`auto_id` ASC),
  CONSTRAINT `fk_rent_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `tsydzik`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rent_auto1`
    FOREIGN KEY (`auto_id`)
    REFERENCES `tsydzik`.`auto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
