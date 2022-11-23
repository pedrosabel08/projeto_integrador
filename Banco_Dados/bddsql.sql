-- MySQL Script generated by MySQL Workbench
-- Wed Aug 31 11:51:36 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Venda` (
  `idVenda` INT NOT NULL auto_increment,
  `idProdutos` INT,
  `idClientes` INT,
  `idFuncionario` INT,
  `valor` DOUBLE NULL,
  `data` DATE NULL,
  PRIMARY KEY (`idVenda`),
   CONSTRAINT `fk_Venda_has_Produtos_Produtos1`
    FOREIGN KEY (`idProdutos`)
    REFERENCES `mydb`.`Produtos` (`idProdutos`),
    
	CONSTRAINT `fk_Venda_Clientes`
    FOREIGN KEY (`idClientes`)
    REFERENCES `mydb`.`Clientes` (`idClientes`),
    
	CONSTRAINT `fk_Venda_Funcionario`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `mydb`.`Funcionario` (`idFuncionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Clientes` (
  `idClientes` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `data_nascimento` DATE NULL,
  PRIMARY KEY (`idClientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `idFuncionario` INT NOT NULL auto_increment,
  `senha` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idFuncionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produtos` (
  `idProdutos` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NULL,
  `marca` VARCHAR(45) NULL,
  `tamanho` VARCHAR(15) NULL,
  `cor` VARCHAR(45) NULL,
  `preco` VARCHAR(45) NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`idProdutos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `idFornecedor` INT NOT NULL auto_increment,
  `cnpj` VARCHAR(45) NULL,
  `contato` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Venda_has_Produtos`
-- -----------------------------------------------------



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (1, 'Emelyne Partleton', '441.319.330-04', '34.087.029-1', "1976-07-29");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (2, 'Gib Cragoe', '408.227.200-35', '30.732.433-3', "1991-03-26");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (3, 'Brandi Lidden', '660.524.420-69', '46.335.287-7', "1966-03-27");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (4, 'Jolee Barrett', '775.716.280-75', '13.854.527-3', "1978-05-05");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (5, 'Nedi Dugood', '216.569.730-14', '31.938.349-0', "1965-07-05");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (6, 'Gordie Mazonowicz', '440.825.790-79', '33.099.294-6', "1990-08-08");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (7, 'Leesa Elsby', '824.040.660-21', '37.706.974-7', "1995-12-18");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (8, 'Rosemaria Howbrook', '713.569.540-22', '12.209.062-7', "1971-01-19");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (9, 'Brendon Baynton', '754.641.750-32', '19.623.572-8', "1976-11-30");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (10, 'Maible Aubin', '237.106.760-10', '26.971.984-2', "1974-10-08");


insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (1, 'Camisa', 'Hering', 'S', 'Violet', '35', 92);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (2, 'Calça', 'Off-White', 'L', 'Violet', '20', 23);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (3, 'Camiseta', 'Supreme', 'M', 'Goldenrod', '28', 73);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (4, 'Cinto', 'Off-White', 'G', 'Teal', '45', 25);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (5, 'Regata', 'Nike', '3XL', 'Orange', '39', 84);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (6, 'Camisa Polo', 'Lacoste', 'M', 'Preta', '64', 123);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (7, 'Bermuda', 'Cyclone', 'GG', 'Red', '97', 73);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (8, 'Shorts', 'Adidas', 'M', 'Aquamarine', '12', 62);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (9, 'Jaqueta', 'Riachuelo', 'M', 'Blue', '62', 47);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (10, 'Moletom', 'Grizzly', 'G', 'Purple', '34', 93);




insert into Funcionario (idFuncionario, senha, nome) values (1, '12345', 'Pedro');

insert into Funcionario (idFuncionario, senha, nome) values (2, '12345', 'Arthur');

insert into Funcionario (idFuncionario, senha, nome) values (3, '12345', 'Eduardo');


insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (1, '47.474.698/0001-40', ' (49) 3853-3231', 'Burk Plover');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (2, '95.322.810/0001-70', ' (83) 2254-2818', 'Karleen Brewett');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (3, '73.224.259/0001-90', ' (73) 2056-7033', 'Samuele Acom');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (4, '69.427.339/0001-75', ' (98) 3881-7264', 'Kristian Dawes');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (5, '17.627.024/0001-78', ' (97) 3227-6595', 'Tadd Oakman');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (6, '80.107.368/0001-92', ' (98) 3625-7628', 'Edgard Domange');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (7, '25.854.123/0001-10', ' (65) 2152-4375', 'Karil Hearons');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (8, '14.459.938/0001-89', ' (96) 2374-9417', 'Kiley Cloake');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (9, '85.825.878/0001-19', ' (86) 2417-5347', 'Linet Furley');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (10, '33.958.886/0001-30', ' (91) 3521-4808', 'Rhiamon Kinde');


 