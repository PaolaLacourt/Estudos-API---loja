CREATE DATABASE  IF NOT EXISTS `loja_pabt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `loja_pabt`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: loja_pabt
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` int(11) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `municipio` varchar(255) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'60048926000189','feiraosp@gmail.com','Jardim Europa',4488004,'sala04','Sao Paulo','Rua Jardin','Sao Paulo',0,'Feirão de SP','1199988776655'),(2,'80835519023','joaooliveira@gmail.com','Jardim Europa',4477004,'','Sao Paulo','Rua Alegria','Sao Paulo',0,'João Oliveira','1199988776688'),(3,'80835519023','joaooliveira@gmail.com','Jardim Europa',4477004,'','Sao Paulo','Rua Alegria','Sao Paulo',22,'João Oliveira','1199988776688'),(4,'93248197048','mariadossantos@gmail.com','Pinheiros',4445004,'Apto.202','Sao Paulo','Rua das Amoras','Sao Paulo',136,'Maria dos Santos','1199988576688'),(5,'68309030096','anadasilva@hotmail.com','Pinheiros',4478004,'Apto.122','Sao Paulo','Rua das Árvores','Sao Paulo',1024,'Ana da Silva','1199918576688');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbao8t45ccm7aho5ntxs0ax7kt` (`nome_id`),
  CONSTRAINT `FKbao8t45ccm7aho5ntxs0ax7kt` FOREIGN KEY (`nome_id`) REFERENCES `fornecedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor_de_venda` double NOT NULL,
  `id_produto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6os6awodgd9ika474xkr2nncf` (`id_produto_id`),
  CONSTRAINT `FK6os6awodgd9ika474xkr2nncf` FOREIGN KEY (`id_produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` int(11) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `municipio` varchar(255) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'60048926000189','feiraosp@gmail.com','Jardim Europa',4488004,'sala04','Sao Paulo','Rua Jardin','Sao Paulo',12,'Feirão de SP','1199988776655'),(2,'74162215000145','amaliaatacado@gmail.com','Centro',4489005,'sala21','Sao Paulo','Avenida Brasil','Sao Paulo',1055,'Amália Atacado','1199988778955'),(3,'88450357000112','joaomariamachado@gmail.com','Liberdade',4478005,'','Sao Paulo','Rua Pequena','Sao Paulo',134,'João Maria Machado','1199982378955');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_comprados`
--

DROP TABLE IF EXISTS `itens_comprados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_comprados` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  `compra_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfwtqg5a3475fuyljvh2kn3k1j` (`produto_id`),
  KEY `FKk22wbc31vjewj7n8qp3djtafx` (`compra_id`),
  CONSTRAINT `FKfwtqg5a3475fuyljvh2kn3k1j` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `FKk22wbc31vjewj7n8qp3djtafx` FOREIGN KEY (`compra_id`) REFERENCES `compra` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_comprados`
--

LOCK TABLES `itens_comprados` WRITE;
/*!40000 ALTER TABLE `itens_comprados` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_comprados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_vendidos`
--

DROP TABLE IF EXISTS `itens_vendidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_vendidos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  `venda_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf6i04ypbkdquhbnhkg1n83kor` (`produto_id`),
  KEY `FK5tu1x8c37t69u7a6c8y0m6w98` (`venda_id`),
  CONSTRAINT `FK5tu1x8c37t69u7a6c8y0m6w98` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`),
  CONSTRAINT `FKf6i04ypbkdquhbnhkg1n83kor` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_vendidos`
--

LOCK TABLES `itens_vendidos` WRITE;
/*!40000 ALTER TABLE `itens_vendidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_vendidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'Loja'),(2,'Cliente');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `unidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Saia do tipo bandagem na cor cinza, feminina, tamanho único','Saia cz Un','UNIDADE'),(3,'apenas testando put','saia testes','UNIDADE'),(4,'Saia do tipo bandagem na cor vermelha, feminina, tamanho único','Saia verm Un','UNIDADE'),(5,'Saia do tipo bandagem na cor rosa, feminina, tamanho único','Saia rosa Un','UNIDADE'),(6,'Saia do tipo bandagem na cor verde, feminina, tamanho único','Saia verde Un','UNIDADE'),(7,'Saia do tipo bandagem na cor amarela, feminina, tamanho único','Saia amr Un','UNIDADE'),(8,'Saia do tipo bandagem na cor preta, feminina, tamanho único','Saia pr Un','UNIDADE'),(9,'Saia do tipo bandagem na cor branca, feminina, tamanho único','Saia br Un','UNIDADE'),(10,'apenas um teste','saia de teste','UNIDADE'),(11,'Camisa na cor branca, feminina, tamanho P','Camisa branca P','UNIDADE'),(12,'Camisa na cor branca, feminina, tamanho M','Camisa branca M','UNIDADE'),(13,'Camisa na cor branca, feminina, tamanho G','Camisa branca G','UNIDADE'),(14,'Camisa na cor branca, feminina, tamanho GG','Camisa branca GG','UNIDADE'),(15,'Camisa na cor preta, feminina, tamanho M','Camisa preta M','UNIDADE'),(16,'Camisa na cor preta, feminina, tamanho GG','Camisa preta GG','UNIDADE'),(17,'Camiseta na cor amarela, feminina, tamanho P','Camiseta amarela P','UNIDADE'),(18,'Camiseta na cor amarela, feminina, tamanho M','Camiseta amarela M','UNIDADE'),(19,'Regata na cor rosa, feminina, tamanho G','Regata rosa G','UNIDADE'),(20,'Regata na cor rosa, feminina, tamanho GG','Regata rosa GG','UNIDADE'),(21,'Saia na cor marrom, feminina, tamanho Unico','Saia marrom Unico','UNIDADE'),(22,'Blazer na cor vermelha, feminina, tamanho P','Blazer Vermelho P','UNIDADE'),(23,'Blazer na cor vermelha, feminina, tamanho M','Blazer Vermelho M','UNIDADE'),(24,'Blazer na cor vinho, feminina, tamanho G','Blazer Vinho G','UNIDADE'),(25,'Blazer na cor vinho, feminina, tamanho GG','Blazer Vinho GG','UNIDADE'),(26,'Calça jeans, feminina, 36','Calça jeans 36','UNIDADE'),(27,'Calça jeans, feminina, 38','Calça jeans 38','UNIDADE'),(28,'Calça jeans, feminina, tamanho 40','Calça jeans 40','UNIDADE'),(29,'Calça jeans, feminina, tamanho 42','Calça jeans 42','UNIDADE'),(30,'Calça jeans, feminina, tamanho 44','Calça jeans 44','UNIDADE'),(31,'Produto teste','Produto','UNIDADE');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@gmail.com','Loja','$2a$10$iiB9deWFzseDL5PHyxOLjOGrT/Qnd33YOGgnVeDtbiRIHD.RS/D9.'),(2,'client@hotmail.com','Cliente','$2a$10$iiB9deWFzseDL5PHyxOLjOGrT/Qnd33YOGgnVeDtbiRIHD.RS/D9.');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_perfil` (
  `usuario_id` bigint(20) NOT NULL,
  `perfil_id` bigint(20) NOT NULL,
  KEY `usuario_id` (`usuario_id`),
  KEY `perfil_id` (`perfil_id`),
  CONSTRAINT `usuario_perfil_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `usuario_perfil_ibfk_2` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_perfil`
--

LOCK TABLES `usuario_perfil` WRITE;
/*!40000 ALTER TABLE `usuario_perfil` DISABLE KEYS */;
INSERT INTO `usuario_perfil` VALUES (2,2),(1,1);
/*!40000 ALTER TABLE `usuario_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_perfis`
--

DROP TABLE IF EXISTS `usuario_perfis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_perfis` (
  `usuario_id` bigint(20) NOT NULL,
  `perfis_id` bigint(20) NOT NULL,
  KEY `FK7bhs80brgvo80vhme3u8m6ive` (`perfis_id`),
  KEY `FKs91tgiyagbilt959wbufiphgc` (`usuario_id`),
  CONSTRAINT `FK7bhs80brgvo80vhme3u8m6ive` FOREIGN KEY (`perfis_id`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FKs91tgiyagbilt959wbufiphgc` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_perfis`
--

LOCK TABLES `usuario_perfis` WRITE;
/*!40000 ALTER TABLE `usuario_perfis` DISABLE KEYS */;
INSERT INTO `usuario_perfis` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `usuario_perfis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK49jqduvptt7r878buwe7kk951` (`nome_id`),
  CONSTRAINT `FK49jqduvptt7r878buwe7kk951` FOREIGN KEY (`nome_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda_itens_da_venda`
--

DROP TABLE IF EXISTS `venda_itens_da_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda_itens_da_venda` (
  `venda_id` bigint(20) NOT NULL,
  `itens_da_venda_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_pdjw9taj57xc64u3slnurnunb` (`itens_da_venda_id`),
  KEY `FKpccthayjux6avetorx8fbjm1w` (`venda_id`),
  CONSTRAINT `FKdj99r73qxqlnhwjxwxj29gm9i` FOREIGN KEY (`itens_da_venda_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `FKpccthayjux6avetorx8fbjm1w` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda_itens_da_venda`
--

LOCK TABLES `venda_itens_da_venda` WRITE;
/*!40000 ALTER TABLE `venda_itens_da_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda_itens_da_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'loja_pabt'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-04 14:22:53
