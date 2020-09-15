/*
 Navicat Premium Data Transfer

 Source Server         : db_LeYou
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db_LeYou

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 10/06/2020 15:08:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for baskets
-- ----------------------------
DROP TABLE IF EXISTS `baskets`;
CREATE TABLE `baskets` (
  `basket_ids` int NOT NULL AUTO_INCREMENT,
  `hw_ids` int DEFAULT NULL,
  `part_ids` int DEFAULT NULL,
  `user_ids` int DEFAULT NULL,
  `count_ids` int DEFAULT NULL,
  `status_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未支付',
  `back_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '该用户没有做评价',
  `adddatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`basket_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';

-- ----------------------------
-- Records of baskets
-- ----------------------------
BEGIN;
INSERT INTO `baskets` VALUES (1, 2, NULL, 1, 3, '已支付', 'aaaaaaa', '2020-06-02 15:11:49');
INSERT INTO `baskets` VALUES (3, 2, NULL, 1, 2, '未支付', 'aaaaa', '2020-06-02 15:36:26');
INSERT INTO `baskets` VALUES (4, NULL, 7, 1, 1, '未支付', 'buhaoyong', '2020-06-02 15:36:56');
INSERT INTO `baskets` VALUES (8, 2, NULL, 2, 2, '已支付', '该用户没有做评价', '2020-06-10 08:09:52');
INSERT INTO `baskets` VALUES (9, NULL, 4, 2, 4, '已支付', 'aaa', '2020-06-09 10:42:24');
INSERT INTO `baskets` VALUES (11, 4, NULL, 2, 1, '已支付', '该用户没有做评价', '2020-06-10 08:09:49');
INSERT INTO `baskets` VALUES (12, 4, NULL, 2, 1, '已支付', '该用户没有做评价', '2020-06-10 08:09:47');
COMMIT;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) DEFAULT NULL,
  `brand_desc` varchar(255) DEFAULT NULL,
  `brand_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brand_id`),
  KEY `brand_name` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='手机品牌表';

-- ----------------------------
-- Records of brand
-- ----------------------------
BEGIN;
INSERT INTO `brand` VALUES (1, 'APPLE', '苹果', '../img/brand/apple.png');
INSERT INTO `brand` VALUES (2, 'HUAWEI', '华为', '../img/brand/huawei.png');
INSERT INTO `brand` VALUES (3, 'OPPO', 'oppo手机', '../img/brand/oppo.png');
INSERT INTO `brand` VALUES (4, 'VIVO', 'vivo手机', '../img/brand/vivo.png');
INSERT INTO `brand` VALUES (5, 'Samsung', '三星', '../img/brand/samsung.png');
INSERT INTO `brand` VALUES (6, 'MEIZU', '魅族', '../img/brand/meizu.png');
INSERT INTO `brand` VALUES (7, 'NOKIA', '诺基亚', '../img/brand/nokia.png');
INSERT INTO `brand` VALUES (8, 'HONOR', '华为荣耀', '../img/brand/honor.png');
INSERT INTO `brand` VALUES (9, 'MI', '小米', '../img/brand/mi.png');
COMMIT;

-- ----------------------------
-- Table structure for hw
-- ----------------------------
DROP TABLE IF EXISTS `hw`;
CREATE TABLE `hw` (
  `hw_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) DEFAULT NULL,
  `hw_name` varchar(255) DEFAULT NULL,
  `hw_price` int DEFAULT NULL,
  `hw_count` int DEFAULT NULL,
  `hw_sales` int DEFAULT NULL,
  `hw_views` varchar(255) DEFAULT NULL,
  `hw_img` varchar(255) DEFAULT NULL,
  `img_l` varchar(255) DEFAULT NULL,
  `img_r` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hw_id`),
  KEY `brand_name` (`brand_name`),
  CONSTRAINT `hw_ibfk_1` FOREIGN KEY (`brand_name`) REFERENCES `brand` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='手机商品表';

-- ----------------------------
-- Records of hw
-- ----------------------------
BEGIN;
INSERT INTO `hw` VALUES (1, 'APPLE', 'Apple苹果iPhone6s', 499, 56431, 45677831, '苹果钉子户', '../img/apple/6s.jpeg', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3775038282,654832400&fm=26&gp=0.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591586105111&di=5453ed2f63af7dfc029329cbaf2df201&imgtype=0&src=http%3A%2F%2Fimage.it168.com%2Fn%2F0x0%2F8%2F8258%2F8258127.jpg');
INSERT INTO `hw` VALUES (2, 'APPLE', 'Apple苹果iPhone7', 1499, 78968, 575859, '苹果基带不好', '../img/apple/7.JPG', '../img/apple/7.JPG', '../img/apple/71.JPG');
INSERT INTO `hw` VALUES (3, 'APPLE', 'Apple苹果iPhone8', 2499, 364272, 373737, '双玻璃机身', '../img/apple/8.PNG', 'https://imgservice.suning.cn/uimg1/b2c/image/H1KUVVxRwKcmvRXokA-LwA.jpg_800w_800h_4e', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591677141453&di=f26056cf8f06f04e142327ab3afd8727&imgtype=0&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2707110109%2C34421734%26fm%3D214%26gp%3D0.jpg');
INSERT INTO `hw` VALUES (4, 'APPLE', 'Apple苹果iPhoneX', 3499, 484848, 437373, '苹果十周年', '../img/apple/x.JPG', 'https://imgservice4.suning.cn/uimg1/b2c/image/kMdkAv2pO9Sy8ioThTLqJw.jpg_400w_400h_4e', 'https://imgservice5.suning.cn/uimg1/b2c/image/BQBpmy5aK_lv32817VPi5Q==.jpg_400w_400h_4e');
INSERT INTO `hw` VALUES (5, 'APPLE', 'Apple苹果iPhone11', 5499, 567885444, 6788899, '苹果最具性价比手机', '../img/apple/11.jpeg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591677056162&di=9a87a58845b1e30581c5e189825e458d&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F93a1775d89e205b7ca918afd8acda0146f7510c4.jpg', 'img/apple/111.PNG');
INSERT INTO `hw` VALUES (6, 'APPLE', 'Apple苹果iPhone11Pro', 9899, 6967969, 98698, '苹果性能最强', '../img/apple/11pro.PNG', '../img/apple/11pro.PNG', '../img/apple/11pro1.PNG');
INSERT INTO `hw` VALUES (7, 'APPLE', 'Apple苹果iPhoneXS', 6899, 6969, 68868, '苹果19年旗舰', '../img/apple/xs.JPG', '../img/apple/xs.JPG', '../img/apple/xs1.JPG');
INSERT INTO `hw` VALUES (8, 'HUAWEI', 'HUAWEI华为mate20', 5499, 587578, 7567657, '华为手机', '../img/huawei/mate30.JPG', NULL, NULL);
INSERT INTO `hw` VALUES (9, 'HUAWEI', 'HUAWEI华为荣耀20', 2699, 7986786, 5675675, '三摄，超大电池', '../img/huawei/p30.JPG', NULL, NULL);
INSERT INTO `hw` VALUES (10, 'VIVO', 'VIVOvivox6', 1950, 6678, 57657, '禽兽性能', '../img/oppo/ace2.jpg', NULL, NULL);
INSERT INTO `hw` VALUES (11, 'OPPO', 'OPPOoppor9', 2199, 687568, 79797, '拍照更清晰', '../img/oppo/x2.jpg', NULL, NULL);
INSERT INTO `hw` VALUES (12, 'MI', 'MI10', 4298, 6787647, 123463, '小米最新手机，骁龙875', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` int NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `news_content` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `news_from` varchar(255) DEFAULT NULL,
  `news_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `news_detail` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `news_up` varchar(255) DEFAULT NULL,
  `news_down` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='手机资讯表';

-- ----------------------------
-- Records of news
-- ----------------------------
BEGIN;
INSERT INTO `news` VALUES (1, '三星发布《2019中国三星企业环境报告书》', '2019中国三星企业环境报告书', '腾讯网', '2020-06-10 08:36:03', '6月5日是一年一度的世界环境日，在此特殊的日子里，三星发布了《2019中国三星企业环境报告书》，通过此报告书，公众也能够更多地了解到三星在中国的环境保护理念、战略和行动。据了解，这也是中国三星向社会公开发布的第九份企业环境报告。中国三星设立“绿色组织”——环境安全委员会，由中国三星总裁直接领导，环境安全部、员工、消费者、NGO及供应商等密切联系，共同建设整个中国三星的绿色经营、绿色工厂和绿色生态；采用循环经济结构，通过推行清洁生产、开展资源综合利用的技术改进、制造优质且持久耐用的产品三方面实现绿色环保。', '13147', '23638');
INSERT INTO `news` VALUES (2, '华为手机5G', '57659', '新华网', '2020-06-02 14:43:42', 'lgjlkglf', '157788', '567858');
COMMIT;

-- ----------------------------
-- Table structure for part
-- ----------------------------
DROP TABLE IF EXISTS `part`;
CREATE TABLE `part` (
  `part_id` int NOT NULL AUTO_INCREMENT,
  `part_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `part_price` int DEFAULT NULL,
  `part_count` int DEFAULT NULL,
  `part_sales` int DEFAULT NULL,
  `part_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `part_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `img_l` varchar(255) DEFAULT NULL,
  `img_r` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`part_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='手机配件表';

-- ----------------------------
-- Records of part
-- ----------------------------
BEGIN;
INSERT INTO `part` VALUES (1, 'airpods', 1499, 6875875, 5858585, 'airpods无线耳机', 'http://wx3.sinaimg.cn/large/701cac0cly4g19muit1hjj212g0u0478.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591586203493&di=e9ea835d6897600cdf447b6ab33cd616&imgtype=0&src=http%3A%2F%2Fzkres2.myzaker.com%2F201903%2F5c9401f377ac644e89306a74_1024.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591586235662&di=4e85eb3a74d72ad3bc2fbb499eea5c62&imgtype=0&src=http%3A%2F%2Fr.sinaimg.cn%2Flarge%2Ftc%2Fhimg2_huanqiu_com%2Ffc2a2a7ab58451709f96d9c6cd9e39df.jpg');
INSERT INTO `part` VALUES (2, 'airpods2', 1999, 56888, 587887, '无线蓝牙耳机2', 'http://img.ommoo.com/nowre/20191029/3vvisldwxfl.jpeg', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3890620006,482150364&fm=26&gp=0.jpg', 'http://www.aihami.com/uploads/allimg/191029/169-191029132959137.jpg');
INSERT INTO `part` VALUES (3, '罗马仕充电宝', 99, 689697, 588585, '罗马仕充电宝20000毫安', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3970750736,1255533920&fm=26&gp=0.jpg', 'http://img2.imgtn.bdimg.com/it/u=3887099836,2284477268&fm=26&gp=0.jpg', 'http://img5.imgtn.bdimg.com/it/u=759614903,414100410&fm=26&gp=0.jpg');
INSERT INTO `part` VALUES (4, '苹果手机壳', 299, 6876868, 6979, '原装硅胶壳', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2649974810,614531058&fm=26&gp=0.jpg', 'http://img2.imgtn.bdimg.com/it/u=2909043706,2302303406&fm=26&gp=0.jpg', 'http://5b0988e595225.cdn.sohucs.com/images/20171208/d0c7dc07031e4dd7a218ec92d96b255b.png');
INSERT INTO `part` VALUES (5, '苹果硅胶壳', 39, 79798, 797, '总有一个颜色属于你', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588770863767&di=edc276d6f248ac74faaff361bf973b0e&imgtype=0&src=http%3A%2F%2Fpic1.58cdn.com.cn%2Fzhuanzh%2Fn_v2d145f07675c04e22b4d09410763266d7.jpg%3Fw%3D750%26h%3D0', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591586439758&di=4b08e774d2ded8d9903adc743f908de6&imgtype=0&src=http%3A%2F%2Fpic7.58cdn.com.cn%2Fzhuanzh%2Fn_v21427e4b80f534b0dafa8f5ce7d6c5b95.jpg%3Fw%3D750%26h%3D0', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3898687631,557368312&fm=26&gp=0.jpg');
INSERT INTO `part` VALUES (6, '苹果钢化膜', 18, 87587, 5876575, '防窥防摔', 'http://6082332.s21i.faiusr.com/2/ABUIABACGAAgm8WPygUooaz3wwQwoAY4oAY.jpg', 'http://img.99114.com/group10/M00/FE/82/rBADsll6zmWAP-gXAAGMwi3HDjU643.jpg', 'http://img1.imgtn.bdimg.com/it/u=4027737308,534156981&fm=26&gp=0.jpg');
INSERT INTO `part` VALUES (7, '手机钢化膜', 6, 798798, 67687, '手机钢化膜', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588770739746&di=5231bb3e511b7db015669056d6279b54&imgtype=0&src=http%3A%2F%2Fimage.suning.cn%2Fuimg%2Fsop%2Fcommodity%2F104902224118023463995539_x.jpg', 'http://image3.suning.cn/uimg/b2c/newcatentries/0070137013-000000000637607914_1_800x800.jpg', 'http://img3.imgtn.bdimg.com/it/u=1416093369,4199929810&fm=26&gp=0.jpg');
INSERT INTO `part` VALUES (8, '手机水凝膜', 12, 68778, 85858, '水凝膜', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1309960599,3778115033&fm=26&gp=0.jpg', 'http://img2.tbcdn.cn/tfscom/i2/2257645376/TB2.63tgjihSKJjy0FeXXbJtpXa_%21%212257645376.jpg', 'http://gfs17.gomein.net.cn/T1EdZgBsKT1RCvBVdK_360.jpg');
INSERT INTO `part` VALUES (9, 'Type-C拓展邬', 199, 587589, 4733535, '转为Mac打造 扩展接口', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys
-- ----------------------------
DROP TABLE IF EXISTS `sys`;
CREATE TABLE `sys` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sys_name` varchar(255) DEFAULT NULL,
  `sys_pass` varchar(255) DEFAULT NULL,
  `sys_role` varchar(255) DEFAULT NULL,
  `sys_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';

-- ----------------------------
-- Records of sys
-- ----------------------------
BEGIN;
INSERT INTO `sys` VALUES (1, 'aa', '123', '超级管理员', '../img/T/aaT.jpg');
INSERT INTO `sys` VALUES (2, 'heima', '234', '普通管理员', '../img/T/sysT.jpg');
INSERT INTO `sys` VALUES (3, 'sys', 'sys', '普通管理员', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pass` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_tel` varchar(255) DEFAULT NULL,
  `adddatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'laoxia', '123456', 'laoxia@qq.com', '19854175434', '2020-06-02 15:07:48');
INSERT INTO `user` VALUES (2, 'aa', '1234', 'aa@qq.com', '19862100859', '2020-06-09 10:39:28');
INSERT INTO `user` VALUES (3, 'yuejl', '026928', '468451731@qq.com', '15628939035', '2020-06-10 08:39:01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
