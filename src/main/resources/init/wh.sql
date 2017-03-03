/*
Navicat MySQL Data Transfer

Source Server         : 192.168.19.202
Source Server Version : 50717
Source Host           : 192.168.19.202:3306
Source Database       : warehouse

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-03 16:57:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_name` varchar(32) NOT NULL COMMENT '货物名称',
  `brand` varchar(32) DEFAULT NULL COMMENT '货物品牌',
  `specification` varchar(32) DEFAULT NULL COMMENT '产品规格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('3', '货物A', 'ASD', '10000', '******');
INSERT INTO `goods` VALUES ('4', '货物1', 'cata', 'x86', 'red');

-- ----------------------------
-- Table structure for `inventory`
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `quantity` int(11) NOT NULL COMMENT '库存量',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('3', '200');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_name` varchar(32) DEFAULT NULL COMMENT '店铺名称',
  `shop_fee` decimal(16,2) NOT NULL DEFAULT '0.00' COMMENT '加盟费',
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('2', '店铺1', '620.00');
INSERT INTO `shop` VALUES ('3', '店铺2', '500.00');

-- ----------------------------
-- Table structure for `statistics`
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `shop_id` bigint(20) NOT NULL,
  `receive_fee_month` decimal(16,2) DEFAULT NULL,
  `send_month` int(11) DEFAULT NULL,
  `send_fee_month` decimal(16,2) DEFAULT NULL,
  `receive_fee_total` decimal(16,2) DEFAULT NULL,
  `send_total` int(11) DEFAULT NULL,
  `send_fee_total` decimal(16,2) DEFAULT NULL,
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statistics
-- ----------------------------

-- ----------------------------
-- Table structure for `trade`
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `trade_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '货物ID',
  `price` decimal(16,2) DEFAULT NULL COMMENT '价格',
  `amount` int(11) DEFAULT NULL COMMENT '交易数量',
  `trade_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `target` bigint(20) DEFAULT NULL COMMENT '交易目标',
  `type` int(1) NOT NULL COMMENT '交易类型（0:收款；1:发货 ; 2: 入库）',
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES ('1', '3', '100.00', '1', '2017-03-01 16:52:54', '2', '1');
INSERT INTO `trade` VALUES ('2', '3', '100.00', '2', '2017-03-02 14:27:05', '2', '1');
INSERT INTO `trade` VALUES ('3', '3', '15.00', '5', '2017-03-02 14:29:47', '2', '1');
INSERT INTO `trade` VALUES ('4', null, '75.00', '1', '2017-03-02 14:53:35', '2', '0');
INSERT INTO `trade` VALUES ('5', null, '75.00', '1', '2017-03-02 14:54:49', '2', '0');
INSERT INTO `trade` VALUES ('6', null, '1.00', '1', '2017-03-02 14:55:25', '2', '0');
INSERT INTO `trade` VALUES ('7', null, '1.00', '1', '2017-03-02 15:02:07', '2', '0');
INSERT INTO `trade` VALUES ('8', '3', '1.00', '1', '2017-03-02 15:02:13', '2', '1');
INSERT INTO `trade` VALUES ('9', null, '11.00', '1', '2017-03-02 15:02:19', '2', '0');
INSERT INTO `trade` VALUES ('10', null, '25.00', '1', '2017-03-02 15:02:24', '2', '0');
INSERT INTO `trade` VALUES ('11', '3', '12.00', '12', '2017-03-02 15:02:29', '2', '1');
INSERT INTO `trade` VALUES ('12', null, '5.00', '1', '2017-03-02 15:02:42', '2', '0');
INSERT INTO `trade` VALUES ('13', '3', '12.00', '1', '2017-03-02 15:35:39', '2', '1');
INSERT INTO `trade` VALUES ('14', null, '12.00', '1', '2017-03-02 15:35:51', '2', '0');
INSERT INTO `trade` VALUES ('15', '4', '3.50', '2', '2017-03-02 15:40:20', '2', '1');
INSERT INTO `trade` VALUES ('16', null, '1.00', '1', '2017-03-02 15:40:28', '2', '0');
INSERT INTO `trade` VALUES ('17', '3', '1.00', '1', '2017-03-02 17:00:18', '2', '1');
INSERT INTO `trade` VALUES ('18', '3', '10.00', '5', '2017-03-02 17:00:48', '2', '1');
INSERT INTO `trade` VALUES ('19', '3', '1.00', '1', '2017-03-03 08:57:53', '2', '1');
INSERT INTO `trade` VALUES ('20', '3', null, '1', '2017-03-03 08:58:23', null, '2');
INSERT INTO `trade` VALUES ('21', '3', null, '21', '2017-03-03 08:58:27', null, '2');
INSERT INTO `trade` VALUES ('22', '3', '2.00', '11', '2017-03-03 08:58:39', '2', '1');
INSERT INTO `trade` VALUES ('23', null, '3.00', '1', '2017-03-03 09:59:20', '2', '0');
