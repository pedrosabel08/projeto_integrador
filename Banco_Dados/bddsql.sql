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
  `valor` DOUBLE NULL,
  `data` DATE NULL,
  PRIMARY KEY (`idVenda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Clientes` (
  `idClientes` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(14) NULL,
  `rg` INT NULL,
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

insert into Venda (idVenda, valor, data) values (1, 35 , "2022-08-02");

insert into Venda (idVenda, valor, data) values (2, 68 ,  "2022-05-07");

insert into Venda (idVenda, valor, data) values (3, 51, "2021-05-11");

insert into Venda (idVenda, valor, data) values (4, 39, "2022-02-04");

insert into Venda (idVenda, valor, data) values (5, 42, "2021-08-23");

insert into Venda (idVenda, valor, data) values (6, 25, "2022-02-16");

insert into Venda (idVenda, valor, data) values (7, 94, "2022-07-18");

insert into Venda (idVenda, valor, data) values (8, 49,  "2021-09-17");

insert into Venda (idVenda, valor, data) values (9, 36, "2022-05-05");

insert into Venda (idVenda, valor, data) values (10, 72, "2022-01-31");


insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (1, 'Emelyne Partleton', '35203765121111', 3843298, "1976-07-29");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (2, 'Gib Cragoe', '92566136892222', 4343846, "1991-03-26");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (3, 'Brandi Lidden', '91482753443333', 1576831, "1966-03-27");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (4, 'Jolee Barrett', '1846893240444', 2000487, "1978-05-05");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (5, 'Nedi Dugood', '20270209855555', 91816708, "1965-07-05");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (6, 'Gordie Mazonowicz', '16205353516666', 1623514, "1990-08-08");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (7, 'Leesa Elsby', '0110854497777', 4395857, "1995-12-18");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (8, 'Rosemaria Howbrook', '40400122678888', 4990844, "1971-01-19");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (9, 'Brendon Baynton', '04000013819999', 3693552, "1976-11-30");

insert into Clientes (idClientes ,nome, cpf, rg, data_nascimento) values (10, 'Maible Aubin', '20014421490000', 5953373, "1974-10-08");


insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (1, 'Ricca Girke', 'health mart allergy relief', 'S', 'Violet', '35', 92);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (2, 'Creight Mila', 'shoprite ni-calm', 'L', 'Violet', '20', 23);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (3, 'Devan Lichtfoth', 'Dr. Jart Shimmering Beauty Balm', 'M', 'Goldenrod', '28', 73);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (4, 'Gaylor Antal', 'Chelidonium Homaccord', 'XS', 'Teal', '45', 25);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (5, 'Beltran Dearness', 'Perphenazine', '3XL', 'Orange', '39', 84);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (6, 'Ignacius McAusland', 'BLUE ACME SLEEVE FIRST AID', 'M', 'Red', '64', 123);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (7, 'Alano Glew', 'Donepezil Hydrochloride', '3XL', 'Red', '97', 73);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (8, 'Livvy Noirel', 'Up and Up Acetaminophen', 'M', 'Aquamarine', '12', 62);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (9, 'Nancey Cork', 'Aspirin', 'M', 'Blue', '62', 47);

insert into Produtos (idProdutos, nome, marca, tamanho, cor, preco, quantidade) values (10, 'Lyell Brennon', 'ProFormance Series Foam', '2XL', 'Purple', '34', 93);



insert into Funcionario (idFuncionario, senha, nome) values (1, 'Um3Wcbs6sUM', 'Morris Kolczynski');

insert into Funcionario (idFuncionario, senha, nome) values (2, 'KzesyJSUSIL', 'Sara Rockhill');

insert into Funcionario (idFuncionario, senha, nome) values (3, 'M0MDfu0HqveC', 'Karolina Benard');

insert into Funcionario (idFuncionario, senha, nome) values (4, 'STdp4v', 'Chilton Atteridge');

insert into Funcionario (idFuncionario, senha, nome) values (5, 'xPseBD8p7', 'Dinnie Bauman');

insert into Funcionario (idFuncionario, senha, nome) values (6, '2UHujULr', 'Babbie Baumert');

insert into Funcionario (idFuncionario, senha, nome) values (7, 'cNI2Yh6', 'Ty Nutley');

insert into Funcionario (idFuncionario, senha, nome) values (8, 'OZTcVP2', 'Allis Brandolini');

insert into Funcionario (idFuncionario, senha, nome) values (9, 'TWrLAhpTu', 'Olivette Major');

insert into Funcionario (idFuncionario, senha, nome) values (10, 'T7N5AU0', 'Dario Kilsby');

insert into Funcionario (idFuncionario, senha, nome) values (11, '12345', 'Pedro');

insert into Funcionario (idFuncionario, senha, nome) values (12, '12345', 'Arthur');


insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (1, '47.474.698/0001-40', '(930) 8396815', 'Burk Plover');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (2, '95.322.810/0001-70', '(394) 1551540', 'Karleen Brewett');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (3, '73.224.259/0001-90', '(877) 6633184', 'Samuele Acom');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (4, '69.427.339/0001-75', '(912) 3697795', 'Kristian Dawes');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (5, '17.627.024/0001-78', '(562) 4676405', 'Tadd Oakman');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (6, '80.107.368/0001-92', '(956) 2395462', 'Edgard Domange');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (7, '25.854.123/0001-10', '(215) 3104716', 'Karil Hearons');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (8, '14.459.938/0001-89', '(949) 9319835', 'Kiley Cloake');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (9, '85.825.878/0001-19', '(975) 5537978', 'Linet Furley');

insert into Fornecedor (idFornecedor, cnpj, contato, nome) values (10, '33.958.886/0001-30', '(384) 8330538', 'Rhiamon Kinde');


 