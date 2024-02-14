-- --------------------------------------------------------
-- Servidor:                     10.68.3.235
-- Versão do servidor:           8.0.33 - MySQL Community Server - GPL
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para minhas-financas
CREATE DATABASE IF NOT EXISTS `minhas-financas` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `minhas-financas`;

-- Copiando estrutura para tabela minhas-financas.cartao_credito
CREATE TABLE IF NOT EXISTS `cartao_credito` (
  `dia_fechamento` decimal(38,2) NOT NULL,
  `dia_vencimento` decimal(38,2) NOT NULL,
  `limite` decimal(38,2) NOT NULL,
  `id` binary(16) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.cartao_credito: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela minhas-financas.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` binary(16) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.categoria: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela minhas-financas.conta
CREATE TABLE IF NOT EXISTS `conta` (
  `saldo` decimal(38,2) NOT NULL,
  `id` binary(16) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.conta: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela minhas-financas.despesa_cartao
CREATE TABLE IF NOT EXISTS `despesa_cartao` (
  `data_lancamento` date NOT NULL,
  `efetivada` bit(1) NOT NULL,
  `mes_ano_fatura` date NOT NULL,
  `recorrente` bit(1) NOT NULL,
  `valor` decimal(38,2) NOT NULL,
  `categoria_id` binary(16) DEFAULT NULL,
  `fatura_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `observacao` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4s3hjyltv6cor6up60n3jm743` (`categoria_id`),
  KEY `FKkg4e4bj5dra35fd50elc2bwue` (`fatura_id`),
  CONSTRAINT `FK4s3hjyltv6cor6up60n3jm743` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FKkg4e4bj5dra35fd50elc2bwue` FOREIGN KEY (`fatura_id`) REFERENCES `fatura` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.despesa_cartao: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela minhas-financas.fatura
CREATE TABLE IF NOT EXISTS `fatura` (
  `cartao_credito_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `transacao_id` binary(16) DEFAULT NULL,
  `ano` varchar(256) DEFAULT NULL,
  `mes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mqig3t15du02v5aui45kbsqa9` (`transacao_id`),
  KEY `FKav29dx6qjjkkmfn5hwf6ia3f4` (`cartao_credito_id`),
  CONSTRAINT `FKav29dx6qjjkkmfn5hwf6ia3f4` FOREIGN KEY (`cartao_credito_id`) REFERENCES `cartao_credito` (`id`),
  CONSTRAINT `FKba94hinpaj4akv2uum1payvju` FOREIGN KEY (`transacao_id`) REFERENCES `transacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.fatura: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela minhas-financas.transacao
CREATE TABLE IF NOT EXISTS `transacao` (
  `data_efetivado` date DEFAULT NULL,
  `data_lancamento` date NOT NULL,
  `data_vencimento` date NOT NULL,
  `efetivada` bit(1) NOT NULL,
  `recorrente` bit(1) NOT NULL,
  `tipo_transacao` tinyint NOT NULL,
  `valor` decimal(38,2) NOT NULL,
  `categoria_id` binary(16) DEFAULT NULL,
  `conta_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `observacao` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1i3bdmrp3xf5fvs84gc9w2iid` (`categoria_id`),
  KEY `FK6968iodq71yxdsg3ctxmnffv1` (`conta_id`),
  CONSTRAINT `FK1i3bdmrp3xf5fvs84gc9w2iid` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK6968iodq71yxdsg3ctxmnffv1` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id`),
  CONSTRAINT `transacao_chk_1` CHECK ((`tipo_transacao` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.transacao: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela minhas-financas.transferencia
CREATE TABLE IF NOT EXISTS `transferencia` (
  `data_efetivado` date DEFAULT NULL,
  `data_lancamento` date NOT NULL,
  `data_vencimento` date NOT NULL,
  `efetivada` bit(1) NOT NULL,
  `recorrente` bit(1) NOT NULL,
  `valor` decimal(38,2) NOT NULL,
  `categoria_id` binary(16) DEFAULT NULL,
  `conta_entrada` binary(16) DEFAULT NULL,
  `conta_saida` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `observacao` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKyn1ho380d12h1u4nvhejiqeq` (`categoria_id`),
  KEY `FK272ckqjlvolycx3d8ian3p2ur` (`conta_entrada`),
  KEY `FK7kigia53h7wne151r7p4k60r3` (`conta_saida`),
  CONSTRAINT `FK272ckqjlvolycx3d8ian3p2ur` FOREIGN KEY (`conta_entrada`) REFERENCES `conta` (`id`),
  CONSTRAINT `FK7kigia53h7wne151r7p4k60r3` FOREIGN KEY (`conta_saida`) REFERENCES `conta` (`id`),
  CONSTRAINT `FKyn1ho380d12h1u4nvhejiqeq` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela minhas-financas.transferencia: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
