/*
 Navicat Premium Data Transfer

 Source Server         : fim
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 192.168.1.106:30060
 Source Schema         : fim-system

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 22/09/2020 01:11:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for debt_detail
-- ----------------------------
DROP TABLE IF EXISTS `debt_detail`;
CREATE TABLE `debt_detail`  (
  `borrowid` int(11) NOT NULL,
  `userid` int(11) NULL DEFAULT NULL,
  `platid` int(11) NULL DEFAULT NULL,
  `replayment_date` datetime(0) NULL DEFAULT NULL,
  `debts_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(255) NULL DEFAULT NULL,
  `statges` int(255) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` int(255) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` int(11) NULL DEFAULT NULL,
  `isdelete` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`borrowid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for plat
-- ----------------------------
DROP TABLE IF EXISTS `plat`;
CREATE TABLE `plat`  (
  `platid` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` int(255) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` int(11) NULL DEFAULT NULL,
  `isdelete` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`platid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iphone` bigint(255) NULL DEFAULT NULL,
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `create_by` int(255) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `update_by` int(20) NULL DEFAULT NULL,
  `isdelete` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
