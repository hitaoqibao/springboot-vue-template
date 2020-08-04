/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : springboot-vue

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-07-24 18:43:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表ID',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名',
  `description` varchar(50) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'DELETE_USER', '删除用户');
INSERT INTO `permission` VALUES ('2', 'INSERT_USER', '添加用户');
INSERT INTO `permission` VALUES ('3', 'UPDATE_USER', '更新用户');
INSERT INTO `permission` VALUES ('4', 'BUILD_USER', '用户操作');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `description` varchar(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'users', '用户');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限关系表ID',
  `role_id` int(11) NOT NULL COMMENT '索引角色表id',
  `permission_id` int(11) NOT NULL COMMENT '索引权限表id',
  PRIMARY KEY (`id`),
  KEY `fk_role_permission_permission_1` (`permission_id`),
  KEY `fk_role_permission_role_1` (`role_id`),
  CONSTRAINT `fk_role_permission_permission_1` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_permission_role_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');
INSERT INTO `role_permission` VALUES ('4', '1', '4');
INSERT INTO `role_permission` VALUES ('5', '2', '4');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456');
INSERT INTO `user` VALUES ('2', 'root', '123456');
INSERT INTO `user` VALUES ('3', 'user1', '123456');
INSERT INTO `user` VALUES ('4', 'user2', '123456');
INSERT INTO `user` VALUES ('5', '123', '123');
INSERT INTO `user` VALUES ('6', 'aaaaaaaaa', '123456');
INSERT INTO `user` VALUES ('7', 'adminbbbb', '123456');
INSERT INTO `user` VALUES ('8', 'adminadfadsf', '123456');
INSERT INTO `user` VALUES ('9', 'adminasdfadsf', '123456');
INSERT INTO `user` VALUES ('10', 'adsfasdfa', '123456');
INSERT INTO `user` VALUES ('11', 'adminasdfasdf', '123456');
INSERT INTO `user` VALUES ('12', 'adminaccv', '123456');
INSERT INTO `user` VALUES ('13', 'adminssss', '123456');
INSERT INTO `user` VALUES ('14', 'adminccvc', '123456');
INSERT INTO `user` VALUES ('15', 'admincvcv', '123456');
INSERT INTO `user` VALUES ('16', 'qq', '123456');
INSERT INTO `user` VALUES ('17', 'adminasdfds', '123456');
INSERT INTO `user` VALUES ('18', 'adminasdfads', '123456');
INSERT INTO `user` VALUES ('19', 'adminaaa', '123456');
INSERT INTO `user` VALUES ('20', 'adminsadfasd', '123456');
INSERT INTO `user` VALUES ('21', 'aaaaaaa', '123456');
INSERT INTO `user` VALUES ('22', 'admindsfxc', '123456');
INSERT INTO `user` VALUES ('23', 'sdafsdfasd', '123456');
INSERT INTO `user` VALUES ('24', 'adminxcvxc', '123456');
INSERT INTO `user` VALUES ('25', 'adminaasdf', '123456');
INSERT INTO `user` VALUES ('26', 'admindsfasdf', '123456');
INSERT INTO `user` VALUES ('27', 'admin555', '123456');
INSERT INTO `user` VALUES ('28', 'admin555asdf', '123456');
INSERT INTO `user` VALUES ('29', 'admincvzxc', '123456');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系表ID',
  `user_id` int(11) NOT NULL COMMENT '索引用户表id',
  `role_id` int(11) NOT NULL COMMENT '索引角色表id',
  PRIMARY KEY (`id`),
  KEY `fk_user_role_role_1` (`role_id`),
  KEY `fk_user_role_user_1` (`user_id`),
  CONSTRAINT `fk_user_role_role_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '1');
INSERT INTO `user_role` VALUES ('3', '3', '2');
INSERT INTO `user_role` VALUES ('4', '4', '2');
