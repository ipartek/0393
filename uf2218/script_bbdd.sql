-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema videos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema videos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `v2019` DEFAULT CHARACTER SET utf8 ;
USE `v2019` ;

-- -----------------------------------------------------
-- Table `videos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videos`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `contrasenya` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videos`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videos`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videos`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videos`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `codigo` VARCHAR(11) NOT NULL,
  `usuario_id` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  INDEX `fk_video_usuario_idx` (`usuario_id` ASC),
  INDEX `fk_video_categoria1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_video_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `videos`.`usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_video_categoria`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `videos`.`categoria` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videos`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videos`.`likes` (
  `usuario_id` INT NOT NULL,
  `video_id` INT NOT NULL,
  `fecha` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario_id`, `video_id`),
  INDEX `fk_usuario_has_video_video1_idx` (`video_id` ASC),
  INDEX `fk_usuario_has_video_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_usuario_likes_video`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `videos`.`usuario` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_video_likes_usuario`
    FOREIGN KEY (`video_id`)
    REFERENCES `videos`.`video` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
