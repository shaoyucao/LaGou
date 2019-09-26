/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : lagouwang

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 26/09/2019 16:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lagoujob
-- ----------------------------
DROP TABLE IF EXISTS `lagoujob`;
CREATE TABLE `lagoujob`  (
  `jobID` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jobName` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jobSalary` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jobCompany` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jobID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
