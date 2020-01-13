-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Movie_Cruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Movie_Cruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Movie_Cruiser` DEFAULT CHARACTER SET utf8 ;
USE `Movie_Cruiser` ;

-- -----------------------------------------------------
-- Table `Movie_Cruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movie_Cruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Cruiser`.`movie_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movie_Cruiser`.`movie_list` (
  `mo_id` INT NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL,
  `mo_gross` DECIMAL NULL,
  `mo_active` VARCHAR(3) NULL,
  `mo_date_of_launch` DATE NULL,
  `mo_genre` VARCHAR(45) NULL,
  `mo_has_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Cruiser`.`favourites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movie_Cruiser`.`favourites` (
  `fv_id` INT NOT NULL AUTO_INCREMENT,
  `fv_us_id` INT NULL,
  `fv_gr_id` INT NULL,
  PRIMARY KEY (`fv_id`),
  INDEX `fv_us_id_idx` (`fv_us_id` ASC),
  INDEX `fv_gr_id_idx` (`fv_gr_id` ASC),
  CONSTRAINT `fv_us_id`
    FOREIGN KEY (`fv_us_id`)
    REFERENCES `Movie_Cruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fv_gr_id`
    FOREIGN KEY (`fv_gr_id`)
    REFERENCES `Movie_Cruiser`.`movie_list` (`mo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
