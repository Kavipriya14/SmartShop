-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema smartshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema smartshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smartshop` DEFAULT CHARACTER SET utf8 ;
USE `smartshop` ;

-- -----------------------------------------------------
-- Table `smartshop`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`user` (
  `user_id` VARCHAR(15) NOT NULL DEFAULT 'null',
  `user_firstname` VARCHAR(50) NOT NULL,
  `user_lastname` VARCHAR(50) NOT NULL,
  `user_age` INT(2) NOT NULL,
  `user_gender` VARCHAR(50) NOT NULL DEFAULT 'null',
  `user_contact_no` VARCHAR(10) NOT NULL,
  `user_password` VARCHAR(200) NOT NULL,
  `user_type` VARCHAR(1) NOT NULL,
  `user_status` VARCHAR(1) NOT NULL,
  `user_answer` VARCHAR(50) NOT NULL,
  `secret_question` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`assessment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`assessment` (
  `a_id` INT(11) NOT NULL,
  `fk_us_id` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`a_id`),
  INDEX `fk_user_id_idx` (`fk_us_id` ASC),
  CONSTRAINT `fk_us_id`
    FOREIGN KEY (`fk_us_id`)
    REFERENCES `smartshop`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`feedback_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`feedback_question` (
  `fq_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fd_question` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`fq_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`feedback_answers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`feedback_answers` (
  `fa_id` INT(11) NOT NULL,
  `fk_as_id` INT(11) NOT NULL,
  `fk_fq_id` INT(11) NOT NULL,
  `fa_answer` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`fa_id`),
  INDEX `fk_fq_id_idx` (`fk_fq_id` ASC),
  INDEX `fk_as_id_idx` (`fk_as_id` ASC),
  CONSTRAINT `fk_as_id`
    FOREIGN KEY (`fk_as_id`)
    REFERENCES `smartshop`.`assessment` (`a_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fq_id`
    FOREIGN KEY (`fk_fq_id`)
    REFERENCES `smartshop`.`feedback_question` (`fq_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`product` (
  `pr_code` VARCHAR(50) NOT NULL DEFAULT 'null',
  `pr_name` VARCHAR(50) NOT NULL,
  `pr_type` VARCHAR(50) NOT NULL,
  `pr_brand` VARCHAR(50) NOT NULL,
  `pr_rate` INT(11) NOT NULL,
  `pr_stock` INT(11) NOT NULL,
  `pr_add_date` DATE NOT NULL,
  `pr_aisle` VARCHAR(15) NOT NULL,
  `pr_shelf` VARCHAR(15) NOT NULL,
  `pr_date_manufacture` DATE NOT NULL,
  `pr_date_expiry` DATE NOT NULL,
  `pr_image` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`pr_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`purchase` (
  `pu_id` INT(11) NOT NULL,
  `pu_date` DATE NOT NULL,
  `pu_amount` INT(10) NOT NULL,
  `fk_user_id` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`pu_id`),
  INDEX `fk_bill_user1_idx` (`fk_user_id` ASC),
  CONSTRAINT `fk_bill_user1`
    FOREIGN KEY (`fk_user_id`)
    REFERENCES `smartshop`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`quantity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`quantity` (
  `q_id` INT(11) NOT NULL AUTO_INCREMENT,
  `q_quantity` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`q_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`purchase_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`purchase_history` (
  `ph_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_pr_code` VARCHAR(50) NULL DEFAULT NULL,
  `fk_pu_id` INT(11) NULL DEFAULT NULL,
  `fk_q_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ph_id`),
  INDEX `fk_pr_code_idx` (`fk_pr_code` ASC),
  INDEX `fk_bill_id_idx` (`fk_pu_id` ASC),
  INDEX `fk_q_id_idx` (`fk_q_id` ASC),
  CONSTRAINT `fk_bill_id`
    FOREIGN KEY (`fk_pu_id`)
    REFERENCES `smartshop`.`purchase` (`pu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pr_code`
    FOREIGN KEY (`fk_pr_code`)
    REFERENCES `smartshop`.`product` (`pr_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_q_id`
    FOREIGN KEY (`fk_q_id`)
    REFERENCES `smartshop`.`quantity` (`q_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

use smartshop;
insert into user values('superuser','Kavi','priya','21','female','9087659633','$2a$10$1pLJBqpWSeOc3VFvTylA2uaCSigUhp.xpRl8ZEfhUoc/qL.fsHrK.','S','A','Vijay','Who is your favorite film star?');
insert into purchase values(1,'2015-12-12',0,'superuser');
insert into smartshop.product values("HAT001","TV","HomeAppliance","Onida",250000,5,"2019-11-26","P5","B2","2019-03-12","2040-03-12","https://images.unsplash.com/photo-1552975084-6e027cd345c2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
insert into smartshop.product values("PCA002","Soap","PersonalCare","Medimix",40,150,"2019-11-26","P7","B3","2019-07-05","2025-07-05","https://5.imimg.com/data5/KC/PJ/GLADMIN-30765893/medimix-transparent-soap-500x500.png");
insert into smartshop.product values("BV045","Coke","Beverages","Coco Cola",20,70,"2019-11-26","P9","B7","2019-10-25","2027-10-25","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVLeBMVPB7OJsZpIvY1jvfKoUmNV5ZViUCoeRU8_h6WaBgCJIxVA&s");
