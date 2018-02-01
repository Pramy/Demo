/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-02-02 03:22:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `parent_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='节点表';

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '一级节点A', '0');
INSERT INTO `node` VALUES ('2', '一级节点B', '0');
INSERT INTO `node` VALUES ('3', '一级节点C', '0');
INSERT INTO `node` VALUES ('4', '二级节点AA', '1');
INSERT INTO `node` VALUES ('5', '二级节点aa', '1');
INSERT INTO `node` VALUES ('6', '二级节点BB', '2');
INSERT INTO `node` VALUES ('7', '三级级节点AAA', '4');
INSERT INTO `node` VALUES ('8', '三级级节点aaa', '4');
INSERT INTO `node` VALUES ('9', '三级级节点BBB', '6');
