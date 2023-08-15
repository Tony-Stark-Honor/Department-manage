/*
Navicat MySQL Data Transfer

Source Server         : MySql8.0
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : department

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-07-24 14:49:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '访客ID',
  `deptId` char(5) NOT NULL,
  `date` datetime NOT NULL COMMENT '学生开锁时间',
  PRIMARY KEY (`id`),
  KEY `stuId` (`stuId`) USING BTREE,
  KEY `deptId` (`deptId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', '180101', '9c203', '2023-06-05 08:01:35');
INSERT INTO `client` VALUES ('2', '180101', '9c203', '2023-06-05 08:25:08');
INSERT INTO `client` VALUES ('3', '180101', '9c203', '2023-06-05 08:25:11');
INSERT INTO `client` VALUES ('4', '180101', '9c203', '2023-06-05 09:20:36');
INSERT INTO `client` VALUES ('5', '180101', '9c203', '2023-06-05 10:21:58');
INSERT INTO `client` VALUES ('6', '180101', '9c203', '2023-06-05 16:05:02');
INSERT INTO `client` VALUES ('7', '180101', '9c203', '2023-06-05 16:05:23');
INSERT INTO `client` VALUES ('8', '180101', '9c201', '2023-06-07 16:24:37');
INSERT INTO `client` VALUES ('9', '180101', '9c201', '2023-06-08 21:45:41');
INSERT INTO `client` VALUES ('10', '180101', '9c201', '2023-06-08 22:46:42');
INSERT INTO `client` VALUES ('11', '180101', '9c201', '2023-06-08 23:01:06');
INSERT INTO `client` VALUES ('12', '180101', '9c201', '2023-06-09 09:17:12');
INSERT INTO `client` VALUES ('13', '180101', '9c201', '2023-06-09 09:17:16');
INSERT INTO `client` VALUES ('14', '180101', '9c201', '2023-06-09 09:17:34');
INSERT INTO `client` VALUES ('15', '180101', '9c201', '2023-06-09 09:17:37');
INSERT INTO `client` VALUES ('16', '180101', '9c201', '2023-06-09 09:17:43');
INSERT INTO `client` VALUES ('17', '180101', '9c201', '2023-06-09 09:17:47');
INSERT INTO `client` VALUES ('18', '180101', '9c201', '2023-06-09 09:20:03');
INSERT INTO `client` VALUES ('19', '180101', '9c201', '2023-06-09 09:20:06');
INSERT INTO `client` VALUES ('20', '180101', '9c201', '2023-06-09 09:22:46');
INSERT INTO `client` VALUES ('21', '180101', '9c201', '2023-06-09 09:23:02');
INSERT INTO `client` VALUES ('22', '180101', '9c201', '2023-06-09 09:23:13');
INSERT INTO `client` VALUES ('23', '180101', '9c201', '2023-06-09 09:23:16');
INSERT INTO `client` VALUES ('24', '180101', '9c201', '2023-06-09 10:47:56');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `deptId` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deptType` int NOT NULL COMMENT '宿舍类型（男生or女生）',
  `deptCapacity` int NOT NULL COMMENT '宿舍最大容量',
  `deptStuNum` int NOT NULL COMMENT '当前住宿人数',
  `managerId` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('9c201', '1', '8', '1', 'manager01');
INSERT INTO `department` VALUES ('9c202', '1', '8', '2', 'manager01');
INSERT INTO `department` VALUES ('9c203', '1', '8', '3', 'manager01');
INSERT INTO `department` VALUES ('9c204', '1', '8', '2', 'manager01');
INSERT INTO `department` VALUES ('9c301', '2', '8', '3', 'manager02');
INSERT INTO `department` VALUES ('9c302', '2', '8', '1', 'manager02');
INSERT INTO `department` VALUES ('9c303', '2', '8', '1', 'manager02');
INSERT INTO `department` VALUES ('9c304', '2', '8', '1', 'manager02');

-- ----------------------------
-- Table structure for fault
-- ----------------------------
DROP TABLE IF EXISTS `fault`;
CREATE TABLE `fault` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '报修者',
  `deptId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `faultInfo` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '故障名称',
  `faultImage` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `uploadStatus` tinyint(1) DEFAULT '1' COMMENT '是否上传成功',
  `handleStatus` tinyint(1) DEFAULT '0' COMMENT '管理员是否确认',
  `modifyStatus` tinyint(1) DEFAULT '0' COMMENT '是否修理完成',
  `maintainerId` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stu_id` (`stuId`),
  KEY `dept_id` (`deptId`),
  CONSTRAINT `dept_id` FOREIGN KEY (`deptId`) REFERENCES `department` (`deptId`),
  CONSTRAINT `stu_id` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of fault
-- ----------------------------
INSERT INTO `fault` VALUES ('27', '180101', '9c201', '水管损坏', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/fault/Mh45SClBcXvEJ3Kpt1686278734286.png', '2023-06-09 10:45:40', '1', '1', '1', 'M003');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int NOT NULL AUTO_INCREMENT,
  `stuId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '售卖学生id',
  `deptId` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '宿舍号',
  `goodsName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `goodsPic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品图片',
  `goodsDetail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品描述信息',
  `goodsPrice` double(10,2) DEFAULT NULL COMMENT '商品价格（按分计算）',
  `permission` tinyint(1) DEFAULT '0' COMMENT '是否通过管理员审核',
  `status` tinyint(1) DEFAULT '0' COMMENT '是否售卖',
  PRIMARY KEY (`goodsId`),
  KEY `stu` (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', '180201', '9c204', '手提包', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/%E6%89%8B%E6%8F%90%E5%8C%85.png?sign=ba19d0b7975f10923d63ab9b42ababea&t=1686229936', '出手提包，九成新，需要的联系', '19.99', '0', '0');
INSERT INTO `goods` VALUES ('4', '180103', '9c301', '充电宝', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/%E5%85%85%E7%94%B5%E5%AE%9D.png?sign=eedae0d132f390caddb3da35407858fd&t=1686229898', '出充电宝，有意者联系', '29.99', '1', '1');
INSERT INTO `goods` VALUES ('5', '180201', '9c204', '台灯', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/%E5%8F%B0%E7%81%AF.png?sign=6cd93079d21c08c7fe94598375c7a773&t=1686229881', '出台灯，有意者联系', '5.99', '1', '1');
INSERT INTO `goods` VALUES ('9', '180303', '9c201', '钢笔', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/%E7%AC%94.png?sign=af4378280d3971886355e6eb4ae4db1d&t=1686229861', '出二手钢笔，赠字帖', '9.99', '1', '0');
INSERT INTO `goods` VALUES ('14', '180307', '9c202', '桌子', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/QQ%E6%88%AA%E5%9B%BE20230605124442.png?sign=5daecbad9691074141a65f830c269aa7&t=1686229840', '出二手床上桌，有意者下单', '19.99', '1', '0');
INSERT INTO `goods` VALUES ('20', '180101', '9c201', '台灯', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/O5YSVc1dpkimfaQAj1686273379349.png', '出二手台灯', '9.99', '1', '0');
INSERT INTO `goods` VALUES ('21', '180101', '9c201', '台灯', 'https://636c-cloud-5gu60bye128916ff-1317934453.tcb.qcloud.la/goods/4S1l30C4ySE5RirZt1686278844301.png', '出二手台灯', '9.99', '1', '0');

-- ----------------------------
-- Table structure for living
-- ----------------------------
DROP TABLE IF EXISTS `living`;
CREATE TABLE `living` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuId` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deptId` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of living
-- ----------------------------
INSERT INTO `living` VALUES ('1', '180101', '9c203');
INSERT INTO `living` VALUES ('2', '180102', '9c203');
INSERT INTO `living` VALUES ('3', '180103', '9c301');
INSERT INTO `living` VALUES ('4', '180104', '9c302');
INSERT INTO `living` VALUES ('5', '180201', '9c204');
INSERT INTO `living` VALUES ('6', '180303', '9c201');
INSERT INTO `living` VALUES ('7', '180307', '9c202');
INSERT INTO `living` VALUES ('8', '180201', '9c203');
INSERT INTO `living` VALUES ('9', '180301', '9c204');
INSERT INTO `living` VALUES ('11', '180302', '9c303');
INSERT INTO `living` VALUES ('12', '180304', '9c202');
INSERT INTO `living` VALUES ('13', '190101', '9c205');
INSERT INTO `living` VALUES ('14', '130102', '9c205');
INSERT INTO `living` VALUES ('15', '130103', '9c205');

-- ----------------------------
-- Table structure for maintainer
-- ----------------------------
DROP TABLE IF EXISTS `maintainer`;
CREATE TABLE `maintainer` (
  `maintainerId` char(5) NOT NULL,
  `maintainerName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` char(1) NOT NULL,
  PRIMARY KEY (`maintainerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of maintainer
-- ----------------------------
INSERT INTO `maintainer` VALUES ('M001', '胡军', '男');
INSERT INTO `maintainer` VALUES ('M002', '李茹', '女');
INSERT INTO `maintainer` VALUES ('M003', '孙强', '男');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `managerName` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', '李东', '123456', null);
INSERT INTO `manager` VALUES ('manager01', '陈曦', '123456', null);
INSERT INTO `manager` VALUES ('manager02', '李明', '123456', null);
INSERT INTO `manager` VALUES ('manager03', '李晓', '123456', null);
INSERT INTO `manager` VALUES ('manager04', 'Tony', '123456', null);

-- ----------------------------
-- Table structure for purchaserecord
-- ----------------------------
DROP TABLE IF EXISTS `purchaserecord`;
CREATE TABLE `purchaserecord` (
  `id` int NOT NULL AUTO_INCREMENT,
  `purchaserId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sellerId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `goodsPrice` double(6,2) NOT NULL,
  `goodsId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of purchaserecord
-- ----------------------------
INSERT INTO `purchaserecord` VALUES ('5', '180101', '180102', '19.99', '1');
INSERT INTO `purchaserecord` VALUES ('7', '180201', '180101', '100.00', '1');
INSERT INTO `purchaserecord` VALUES ('8', '180101', '180201', '19.99', '2');
INSERT INTO `purchaserecord` VALUES ('9', '180101', '180103', '29.99', '4');
INSERT INTO `purchaserecord` VALUES ('10', '180101', '180201', '5.99', '5');
INSERT INTO `purchaserecord` VALUES ('11', '180101', '180103', '29.99', '4');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deptId` char(5) NOT NULL,
  `score` int NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '9c203', '90', '2023-06-05 06:57:30');
INSERT INTO `score` VALUES ('2', '9c203', '100', '2023-06-01 08:56:01');
INSERT INTO `score` VALUES ('3', '9c201', '80', '2023-06-05 16:03:03');
INSERT INTO `score` VALUES ('4', '9c203', '100', '2023-06-05 16:03:18');
INSERT INTO `score` VALUES ('5', '9c201', '100', '2023-06-07 16:27:52');
INSERT INTO `score` VALUES ('6', '9c201', '80', '2023-06-07 16:28:01');
INSERT INTO `score` VALUES ('7', '9c201', '100', '2023-06-08 21:42:15');
INSERT INTO `score` VALUES ('8', '9c201', '90', '2023-06-08 22:44:18');
INSERT INTO `score` VALUES ('9', '9c201', '100', '2023-06-09 09:15:26');
INSERT INTO `score` VALUES ('10', '9c201', '100', '2023-06-09 10:46:38');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stuName` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stuGender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `managerId` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `stuPwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123456' COMMENT '学生登录密码',
  `account` double(10,2) DEFAULT '100.00' COMMENT '账户余额',
  `deptId` char(5) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  KEY `deptId` (`deptId`),
  KEY `managerId` (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('180101', '小明', '男', 'manager01', '123456', '100.00', '9c201');
INSERT INTO `student` VALUES ('180102', '李强', '男', 'manager01', '123456', '100.00', '9c203');
INSERT INTO `student` VALUES ('180103', '小红', '女', 'manager01', '123456', '100.00', '9c301');
INSERT INTO `student` VALUES ('180104', '海棠', '女', 'manager02', '123456', '100.00', '9c302');
INSERT INTO `student` VALUES ('180201', '张三', '男', 'manager01', '123456', '100.00', '9c203');
INSERT INTO `student` VALUES ('180301', '孙军', '男', 'manager01', '123456', '100.00', '9c204');
INSERT INTO `student` VALUES ('180302', '北海', '女', 'manager02', '123456', '100.00', '9c303');
INSERT INTO `student` VALUES ('180303', '张兴', '男', 'manager01', '123456', '100.00', '9c201');
INSERT INTO `student` VALUES ('180304', '张兴', '男', 'manager01', '123456', '100.00', '9c202');
INSERT INTO `student` VALUES ('190101', '吴东', '男', 'manager01', '123456', '100.00', '9c205');
INSERT INTO `student` VALUES ('190102', '马民', '男', 'manager02', '123456', '100.00', '9c205');
INSERT INTO `student` VALUES ('190103', '李星云', '男', 'manager01', '123456', '100.00', '9c205');
INSERT INTO `student` VALUES ('190201', '沈炼', '男', 'manager01', '123456', '100.00', '9c201');
INSERT INTO `student` VALUES ('200102', 'Dale', '男', 'manager01', '123456', '100.00', '9c201');

-- ----------------------------
-- Table structure for temperature
-- ----------------------------
DROP TABLE IF EXISTS `temperature`;
CREATE TABLE `temperature` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuId` char(9) NOT NULL,
  `temperature` double NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of temperature
-- ----------------------------
INSERT INTO `temperature` VALUES ('1', '180101', '36.6', '2023-04-26 15:00:40');
INSERT INTO `temperature` VALUES ('2', '180101', '36.6', '2023-05-15 13:07:00');
INSERT INTO `temperature` VALUES ('3', '180101', '36.6', '2023-05-15 13:28:00');
INSERT INTO `temperature` VALUES ('4', '180101', '36.5', '2023-05-15 13:29:43');
INSERT INTO `temperature` VALUES ('5', '190101', '36.7', '2023-05-15 13:30:58');
INSERT INTO `temperature` VALUES ('6', '190101', '36.7', '2023-05-15 13:31:47');
INSERT INTO `temperature` VALUES ('7', '190102', '36.4', '2023-05-15 13:35:50');
INSERT INTO `temperature` VALUES ('8', '190101', '36.4', '2023-05-15 13:36:30');
INSERT INTO `temperature` VALUES ('9', '190301', '36.5', '2023-05-15 13:38:15');
INSERT INTO `temperature` VALUES ('10', '200101', '36.5', '2023-05-15 13:40:21');
INSERT INTO `temperature` VALUES ('11', '180301', '36.6', '2023-05-15 13:40:41');
INSERT INTO `temperature` VALUES ('12', '180101', '36.6', '2023-05-25 18:21:08');
INSERT INTO `temperature` VALUES ('13', '180101', '36.7', '2023-05-25 18:21:42');
INSERT INTO `temperature` VALUES ('14', '190102', '36.9', '2023-05-25 18:22:21');
INSERT INTO `temperature` VALUES ('15', '180102', '36.5', '2023-05-25 18:22:44');
INSERT INTO `temperature` VALUES ('16', '180103', '36.6', '2023-05-25 18:23:15');
INSERT INTO `temperature` VALUES ('17', '180101', '36.6', '2023-06-05 14:43:34');
INSERT INTO `temperature` VALUES ('18', '180101', '36.6', '2023-06-05 16:03:39');
INSERT INTO `temperature` VALUES ('19', '180101', '36.6', '2023-06-07 16:28:53');
INSERT INTO `temperature` VALUES ('20', '180101', '36.6', '2023-06-08 21:42:46');
INSERT INTO `temperature` VALUES ('21', '180101', '36.6', '2023-06-08 22:44:39');
INSERT INTO `temperature` VALUES ('22', '180101', '36.6', '2023-06-09 09:15:39');
INSERT INTO `temperature` VALUES ('23', '180101', '36.7', '2023-06-09 10:46:55');
