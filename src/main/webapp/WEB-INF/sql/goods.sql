/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : warehouse

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-24 20:21:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT '货物名称',
  `brand` varchar(32) DEFAULT NULL COMMENT '货物品牌',
  `type` int(11) DEFAULT NULL COMMENT '货物类型',
  `specification` varchar(32) DEFAULT NULL COMMENT '货物规格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `trade_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '货物ID',
  `price` decimal(16,2) NOT NULL COMMENT '价格',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `trade_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `target` bigint(20) NOT NULL COMMENT '交易目标',
  `type` int(1) NOT NULL COMMENT '交易类型（0:收款；1:付款）',
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
