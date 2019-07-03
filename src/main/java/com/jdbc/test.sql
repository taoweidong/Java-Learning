/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-07-03 23:21:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` varchar(100) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('2019', '张三', '25', '2019-06-28 22:37:16');
