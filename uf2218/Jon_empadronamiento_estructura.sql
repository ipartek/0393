-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema empadronamiento_jon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empadronamiento_jon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empadronamiento_jon` DEFAULT CHARACTER SET utf8 ;
USE `empadronamiento_jon` ;

-- -----------------------------------------------------
-- Table `empadronamiento_jon`.`municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento_jon`.`municipio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento_jon`.`vivienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento_jon`.`vivienda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `calle` VARCHAR(80) NOT NULL,
  `numero` INT NOT NULL,
  `municipio_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vivienda_municipio_idx` (`municipio_id` ASC),
  CONSTRAINT `fk_vivienda_municipio`
    FOREIGN KEY (`municipio_id`)
    REFERENCES `empadronamiento_jon`.`municipio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento_jon`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento_jon`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(80) NOT NULL,
  `vivienda_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  INDEX `fk_persona_vivienda1_idx` (`vivienda_id` ASC),
  CONSTRAINT `fk_persona_vivienda1`
    FOREIGN KEY (`vivienda_id`)
    REFERENCES `empadronamiento_jon`.`vivienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento_jon`.`tiene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento_jon`.`tiene` (
  `persona_id` INT NOT NULL,
  `vivienda_id` INT NOT NULL,
  PRIMARY KEY (`persona_id`, `vivienda_id`),
  INDEX `fk_persona_has_vivienda_vivienda1_idx` (`vivienda_id` ASC),
  INDEX `fk_persona_has_vivienda_persona1_idx` (`persona_id` ASC),
  CONSTRAINT `fk_persona_has_vivienda_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `empadronamiento_jon`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_has_vivienda_vivienda1`
    FOREIGN KEY (`vivienda_id`)
    REFERENCES `empadronamiento_jon`.`vivienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
