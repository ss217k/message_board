/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : message_board

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-03-02 18:39:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `title` varchar(32) NOT NULL,
  `content` varchar(4096) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('38', '1', 'admin', '2020年3月2日', '留言板建成！！！', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('39', '9', '20156928', '我来发一条留言', '哈哈哈', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('40', '9', '20156928', '刷屏啦', '啦啦啦啦啦啦', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('41', '9', '20156928', '再发一条', '！！！！', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('42', '9', '20156928', '周岩到此一游', '我到此一游', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('43', '9', '20156928', '发一条水水', '灌水', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('44', '9', '20156928', '周岩到此一游', '有bug', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('45', '9', '20156928', '高志文到此一游', '我最可爱', '2020-03-02 00:00:00');
INSERT INTO `message` VALUES ('46', '10', 'zhouyan', '发条试一下', '试试就试试', '2020-03-02 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456');
INSERT INTO `user` VALUES ('2', 'test', '123456');
INSERT INTO `user` VALUES ('9', '20156928', '123456');
INSERT INTO `user` VALUES ('10', 'zhouyan', '123456');
INSERT INTO `user` VALUES ('11', 'gaozhiwen', '123456');
