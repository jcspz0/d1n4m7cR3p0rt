/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 100125
Source Host           : localhost:3306
Source Database       : cliente

Target Server Type    : MYSQL
Target Server Version : 100125
File Encoding         : 65001

Date: 2017-11-04 03:11:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
`ID`  int(11) NOT NULL ,
`NOMBRE`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`SEXO`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`ID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of cliente
-- ----------------------------
BEGIN;
INSERT INTO `cliente` VALUES ('0', '', ''), ('1', 'Juan', 'M'), ('2', 'Carlos', 'M'), ('3', 'Diego', 'M'), ('4', 'Sofia', 'F');
COMMIT;
