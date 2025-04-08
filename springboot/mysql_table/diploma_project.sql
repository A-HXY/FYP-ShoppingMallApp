/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : diploma_project

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 08/04/2025 21:27:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `uid` int(0) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `addr_id` int(0) NOT NULL,
  `addr_province` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `addr_city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `addr_district` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `addr_detail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `addr_defualt` tinyint(1) NOT NULL,
  `del_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`addr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '韦龙', '13197722537', 1, '广西自治区', '柳州市', '城中区', '东环大道广西科技大学168号', 1, 0);
INSERT INTO `address` VALUES (1, '韦龙', '10000', 9, '广西壮族自治区', '桂林市', '秀峰区', '科大文昌校区北区桃花林铁栅栏', 0, 0);
INSERT INTO `address` VALUES (1, '张三三', '13197722537', 12, '河北省', '石家庄市', '长安区', '哈哈哈', 0, 1);
INSERT INTO `address` VALUES (1, '哈喽喽喽喽', '123456789', 13, '陕西省', '西安市', '莲湖区', '西安古都', 0, 0);
INSERT INTO `address` VALUES (2, '张三', '10000', 14, '山西省', '太原市', '小店区', '街道', 0, 0);
INSERT INTO `address` VALUES (13, '韦龙', '13197722537', 15, '浙江省', '杭州市', '西湖区', '大学城', 0, 0);
INSERT INTO `address` VALUES (13, '韦同学', '13197722537', 16, '广西壮族自治区', '柳州市', '城中区', '大学', 1, 0);
INSERT INTO `address` VALUES (20, '韦', '13197722537', 17, '内蒙古自治区', '呼和浩特市', '新城区', '大学', 1, 0);
INSERT INTO `address` VALUES (21, '韦同学', '13197722538', 18, '广西壮族自治区', '柳州市', '城中区', '大学城', 1, 0);

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `bid` int(0) NOT NULL AUTO_INCREMENT COMMENT '轮播图ID',
  `b_imageurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '轮播图URL地址',
  `b_status` tinyint(0) NULL DEFAULT 1 COMMENT '状态：1-启用，0-禁用',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '首页轮播图表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, '/image/banner1.jpg', 1, '2025-04-07 23:53:38', '2025-04-07 23:53:38');
INSERT INTO `banner` VALUES (2, '/image/banner2.jpg', 1, '2025-04-07 23:53:38', '2025-04-07 23:53:38');
INSERT INTO `banner` VALUES (3, '/image/banner3.jpg', 1, '2025-04-07 23:53:38', '2025-04-07 23:53:38');
INSERT INTO `banner` VALUES (4, '/image/img0d55e71c096d4d12a25c92e01b84ee42.jpeg', 1, '2025-04-07 23:53:38', '2025-04-08 00:28:55');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `gid` int(0) NOT NULL COMMENT '商品ID',
  `uid` int(0) NOT NULL COMMENT '用户ID',
  `oid` int(0) NULL DEFAULT NULL COMMENT '订单ID',
  `c_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '评论内容',
  `c_create_time` timestamp(0) NULL DEFAULT NULL COMMENT '评论时间',
  `c_degree` tinyint(0) NULL DEFAULT NULL COMMENT '评分(1-5星)',
  `c_like` int(0) NULL DEFAULT 0 COMMENT '点赞数',
  `c_status` tinyint(0) NULL DEFAULT 1 COMMENT '状态：0-隐藏，1-显示',
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `idx_gid`(`gid`) USING BTREE,
  INDEX `idx_uid`(`uid`) USING BTREE,
  INDEX `idx_oid`(`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, NULL, '超级好吃', '2023-05-09 18:35:43', 5, 1, 0);
INSERT INTO `comment` VALUES (2, 1, 1, NULL, '好吃', '2023-05-09 18:35:43', 4, 1, 1);
INSERT INTO `comment` VALUES (3, 1, 1, NULL, '还行', '2023-05-09 18:35:43', 3, 1, 1);
INSERT INTO `comment` VALUES (4, 1, 1, NULL, '不好吃', '2023-05-09 18:35:43', 1, 1, 1);
INSERT INTO `comment` VALUES (6, 2, 1, NULL, '梨好吃！', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (7, 2, 1, NULL, '梨好吃！', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (8, 1, 1, NULL, '好吃', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (9, 5, 1, NULL, '茉莉花茶好喝！', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (10, 3, 1, NULL, '葡萄好吃！', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (11, 5, 1, NULL, '一般', '2023-05-09 18:35:43', 3, 0, 1);
INSERT INTO `comment` VALUES (12, 2, 1, NULL, '报吃！', '2023-05-09 18:35:43', 1, 0, 1);
INSERT INTO `comment` VALUES (13, 5, 1, NULL, '好喝，很甜。', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (14, 7, 1, NULL, '还不错', '2023-05-09 18:35:43', 4, 0, 1);
INSERT INTO `comment` VALUES (15, 2, 2, NULL, 'NICE', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (16, 2, 2, NULL, '梨好吃', '2023-05-13 01:23:07', 5, 0, 1);
INSERT INTO `comment` VALUES (17, 5, 13, NULL, '2023/4/28 好感和', '2023-05-09 18:35:43', 5, 0, 1);
INSERT INTO `comment` VALUES (18, 5, 13, NULL, 'kkk', '2023-05-09 18:33:39', 4, 0, 0);
INSERT INTO `comment` VALUES (19, 5, 13, NULL, 'kkk', '2023-05-09 18:33:39', 4, 0, 0);
INSERT INTO `comment` VALUES (20, 4, 13, NULL, 'kk', '2023-05-09 18:36:13', 4, 0, 0);
INSERT INTO `comment` VALUES (21, 5, 13, NULL, '好喝！', '2023-05-09 18:55:38', 5, 0, 1);
INSERT INTO `comment` VALUES (22, 2, 21, NULL, '好吃！！！', '2023-05-13 01:34:45', 5, 0, 1);
INSERT INTO `comment` VALUES (23, 24, 21, NULL, '很好喝！ ...', '2023-05-13 01:37:16', 5, 0, 1);
INSERT INTO `comment` VALUES (24, 18, 21, NULL, '前夕！！！', '2023-05-13 01:39:39', 5, 0, 1);
INSERT INTO `comment` VALUES (25, 33, 20, NULL, '66', '2023-05-13 12:35:35', 5, 0, NULL);
INSERT INTO `comment` VALUES (26, 3, 20, NULL, '88', '2023-05-13 12:35:38', 5, 0, NULL);
INSERT INTO `comment` VALUES (27, 35, 15, NULL, '给个回话', '2025-04-08 00:57:01', 4, 0, 1);
INSERT INTO `comment` VALUES (28, 22, 15, NULL, '33333', '2025-04-08 19:57:21', 5, 0, 1);

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `gid` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `gname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `gimage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '/image/default.jpg' COMMENT '商品图片URL',
  `gdetail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '商品详情',
  `gprimal_price` decimal(10, 2) NOT NULL COMMENT '商品原价',
  `gdiscount_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品折扣价',
  `gsale_status` tinyint(0) NULL DEFAULT 0 COMMENT '促销状态：0-不促销，1-促销中',
  `gsale_number` int(0) NULL DEFAULT 0 COMMENT '销量',
  `gnumber` int(0) NULL DEFAULT 0 COMMENT '库存数量',
  `gtype_id` int(0) NOT NULL COMMENT '商品类型ID',
  `gstatus` tinyint(0) NULL DEFAULT 1 COMMENT '商品状态：0-下架，1-上架',
  `gcreate_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gupdate_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`gid`) USING BTREE,
  INDEX `idx_gtype_id`(`gtype_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, 'Apple', '/image/apple.jpg', NULL, 29.90, 24.90, 0, 11, 50, 1, 1, '2023-05-07 23:46:04', '2023-03-12 20:49:53');
INSERT INTO `good` VALUES (2, 'Pear', '/image/pear.jpg', NULL, 29.90, 24.90, 0, 3, 100, 1, 1, '2023-04-10 00:14:59', '2023-03-12 20:51:12');
INSERT INTO `good` VALUES (3, 'Grape', '/image/grape.jpg', '新鲜葡萄', 19.90, 24.90, 0, 21, 100, 2, 1, '2023-05-07 23:46:08', '2023-04-30 15:50:27');
INSERT INTO `good` VALUES (4, 'Water', '/image/mineral_water.jpg', NULL, 2.00, 2.00, 0, 3, 100, 3, 1, '2023-04-10 00:15:00', '2023-03-12 20:51:12');
INSERT INTO `good` VALUES (5, 'Tea', '/image/jasmine_tea.jpg', NULL, 3.50, 3.50, 0, 33, 100, 4, 1, '2023-05-07 23:46:10', '2023-03-12 20:51:12');
INSERT INTO `good` VALUES (6, 'Nuts', '/image/happy_nut.jpg', NULL, 29.90, 24.90, 0, 55, 100, 5, 1, '2023-05-07 23:46:12', '2023-03-12 20:51:12');
INSERT INTO `good` VALUES (7, '夏威夷果', '/image/macadamia_nut.jpg', NULL, 29.90, 24.90, 0, 44, 100, 5, 1, '2023-05-07 23:46:14', '2023-03-12 20:51:12');
INSERT INTO `good` VALUES (8, '苹果苹果苹果苹果苹果苹果苹果苹果苹果苹果', '/image/apple.jpg', NULL, 29.90, 24.90, 0, 3, 50, 1, 1, '2023-05-12 18:39:20', '2023-05-12 18:39:21');
INSERT INTO `good` VALUES (17, '香甜苹果', '/image/img3931c08d94904b4291e220e0df8a10e1.jpeg', 'new', 9.90, 0.00, 0, 5, 99, 1, 0, '2023-05-08 17:02:47', '2023-03-12 20:51:12');
INSERT INTO `good` VALUES (18, '可口蜜茶', '/image/imge16c62ba698f406db16433ab7d4c2e8b.jpeg', '测试！ update 测试！ update 测试！ update 测试！ update', 9.90, 0.00, 0, 6, 99, 4, 1, '2023-05-08 17:03:09', '2023-04-30 15:44:48');
INSERT INTO `good` VALUES (19, 'T', '/image/img03f8956026334f998a7afb90acfedd4b.jpeg', '9999', 9.90, 0.00, 0, 7, 9, 1, 0, '2023-05-07 23:45:59', '2023-05-01 09:17:21');
INSERT INTO `good` VALUES (20, 'TT3', '/image/img8a4faaca731548b0bebd37eefb091571.jpeg', '999', 9.90, 0.00, 0, 8, 9, 1, 1, '2023-05-12 19:14:19', '2023-05-12 19:14:04');
INSERT INTO `good` VALUES (21, '富士苹果', '/image/img9e2c2b8d84bf4720bd7c5f4730d67753.jpeg', '999', 9.90, 0.00, 0, 0, 9, 1, 0, '2023-05-08 17:03:34', '2023-05-01 17:19:27');
INSERT INTO `good` VALUES (22, '红苹果', '/image/img04166702d6174f7a9c896efdf87c41b2.jpeg', '999', 9.00, 0.00, 0, 0, 9, 1, 1, '2023-05-08 17:03:18', '2023-05-01 09:32:26');
INSERT INTO `good` VALUES (23, '茶', '/image/img87aa92c2753842b78861a196e11d2a5c.jpeg', '茶', 3.00, 0.00, 0, 0, 99, 4, 1, '2023-05-01 17:20:25', '2023-05-01 17:20:25');
INSERT INTO `good` VALUES (24, '答辩前夕！', '/image/imga60205e785dd42f8ab248ac58ef0ad21.jpeg', '答辩前夕', 5.00, 0.00, 0, 0, 999, 10, 1, '2023-05-13 01:32:56', '2023-05-13 01:32:56');
INSERT INTO `good` VALUES (25, '超值薯片', '/image/imgc5cbb62c1d2d47e890155054c69c7885.jpeg', '薯片', 9.90, 0.00, 0, 0, 100, 8, 1, '2023-05-13 01:47:13', '2023-05-13 01:47:13');
INSERT INTO `good` VALUES (26, '杂粮辣条', '/image/imge339462f535e4917b8f0dac10757f0f2.jpeg', '杂粮辣条', 5.00, 0.00, 0, 0, 33, 8, 1, '2023-05-13 01:49:56', '2023-05-13 01:49:56');
INSERT INTO `good` VALUES (27, '无穷卤蛋', '/image/img51f5121d419b440e9fe1a63e8f54ff7e.jpeg', '无穷卤蛋', 3.00, 0.00, 0, 0, 99, 8, 1, '2023-05-13 01:51:20', '2023-05-13 01:51:20');
INSERT INTO `good` VALUES (28, '奥利奥', '/image/imgcb52e7b65ebc4a6b85ca252f8f98c0e2.jpeg', '奥利奥', 10.00, 0.00, 0, 0, 66, 5, 1, '2023-05-13 01:52:12', '2023-05-13 01:52:12');
INSERT INTO `good` VALUES (29, '哇哈哈', '/image/imgb23d8223a69d402898ae9f0adc8f700a.jpeg', '哇哈哈', 5.00, 0.00, 0, 0, 88, 4, 1, '2023-05-13 01:55:44', '2023-05-13 01:55:44');
INSERT INTO `good` VALUES (30, '雀巢咖啡', '/image/img7820d905aa7e4146b9777074a6608c97.jpeg', '雀巢咖啡', 15.00, 0.00, 0, 0, 85, 4, 1, '2023-05-13 01:56:53', '2023-05-13 01:56:53');
INSERT INTO `good` VALUES (31, '酸梅饮料', '/image/img51d1a38761864a49bbac6e53defffe64.jpeg', '酸梅饮料', 6.00, 0.00, 0, 0, 55, 4, 1, '2023-05-13 01:58:28', '2023-05-13 01:58:28');
INSERT INTO `good` VALUES (32, '维他命', '/image/img7d95c111cd494cca9d9a401e9bd30dc8.jpeg', '维他命', 6.00, 0.00, 0, 0, 77, 4, 1, '2023-05-13 01:59:42', '2023-05-13 01:59:42');
INSERT INTO `good` VALUES (33, '百岁山', '/image/img1e04299783614560b40f4b95f9951878.jpeg', '百岁山', 4.00, 0.00, 0, 0, 66, 3, 1, '2023-05-13 02:02:33', '2023-05-13 02:02:33');
INSERT INTO `good` VALUES (34, '香蕉', '/image/img4bf7be4e46314be6a13f8c80b7fddc6c.jpeg', '香蕉', 10.00, 0.00, 0, 0, 55, 2, 1, '2023-05-13 02:02:52', '2023-05-13 02:02:52');
INSERT INTO `good` VALUES (35, '1', '/image/imgb7539805cf8845febaf843cefc49457e.png', '1', 1.00, 0.00, 0, 0, 1, 1, 1, '2025-04-08 00:34:59', '2025-04-08 00:34:59');
INSERT INTO `good` VALUES (36, '13123sfasd啊是的发生', '/image/img0aac30b26f8845e882be33b125b1db31.png', '12121啊发生', 12.00, 0.00, 0, 0, 22, 3, 1, '2025-04-08 00:39:23', '2025-04-08 00:39:23');

-- ----------------------------
-- Table structure for goodcategory
-- ----------------------------
DROP TABLE IF EXISTS `goodcategory`;
CREATE TABLE `goodcategory`  (
  `gcategory_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `gcategory_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品分类名称',
  `status` tinyint(0) NULL DEFAULT 1 COMMENT '状态：1-启用，0-禁用',
  PRIMARY KEY (`gcategory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodcategory
-- ----------------------------
INSERT INTO `goodcategory` VALUES (1, '新鲜水果', 1);
INSERT INTO `goodcategory` VALUES (2, '酒水饮料', 1);
INSERT INTO `goodcategory` VALUES (3, '休闲零食', 1);
INSERT INTO `goodcategory` VALUES (4, '生鲜蔬菜', 1);
INSERT INTO `goodcategory` VALUES (5, '传统服饰', 1);
INSERT INTO `goodcategory` VALUES (6, '测测试试', 0);
INSERT INTO `goodcategory` VALUES (7, '答辩前夕', 1);
INSERT INTO `goodcategory` VALUES (8, '123', 1);

-- ----------------------------
-- Table structure for goodtype
-- ----------------------------
DROP TABLE IF EXISTS `goodtype`;
CREATE TABLE `goodtype`  (
  `gcategory_id` int(0) NOT NULL COMMENT '商品分类ID',
  `gtype_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
  `gtype_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品类型名称',
  `status` tinyint(0) NULL DEFAULT 1 COMMENT '状态：1-启用，0-禁用',
  PRIMARY KEY (`gtype_id`) USING BTREE,
  INDEX `idx_gcategory_id`(`gcategory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodtype
-- ----------------------------
INSERT INTO `goodtype` VALUES (1, 1, '苹果梨类', 1);
INSERT INTO `goodtype` VALUES (1, 2, '香蕉葡萄', 1);
INSERT INTO `goodtype` VALUES (2, 3, '矿泉水', 1);
INSERT INTO `goodtype` VALUES (2, 4, '饮料', 1);
INSERT INTO `goodtype` VALUES (3, 5, '坚果饼干', 1);
INSERT INTO `goodtype` VALUES (2, 6, '测试', 1);
INSERT INTO `goodtype` VALUES (5, 7, 'BBCC', 1);
INSERT INTO `goodtype` VALUES (3, 8, '薯片辣条', 1);
INSERT INTO `goodtype` VALUES (5, 9, 'TTT', 1);
INSERT INTO `goodtype` VALUES (7, 10, '前夕晚上', 1);
INSERT INTO `goodtype` VALUES (4, 11, '蔬菜', 1);
INSERT INTO `goodtype` VALUES (8, 12, '1313', 1);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `oid` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `uid` int(0) NOT NULL COMMENT '用户ID',
  `addr_id` int(0) NOT NULL COMMENT '收货地址ID',
  `order_index` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单编号',
  `freight_index` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物流单号',
  `ostatus` tinyint(0) NOT NULL COMMENT '订单状态：1-待付款,2-待发货,3-待收货,4-已完成,5-已取消',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `finishe_time` timestamp(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `payment_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  `delivery_time` timestamp(0) NULL DEFAULT NULL COMMENT '发货时间',
  `price_total` decimal(10, 2) NOT NULL COMMENT '订单总金额',
  `freight_expense` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '运费',
  `payment_mode` tinyint(0) NULL DEFAULT 1 COMMENT '支付方式：1-在线支付',
  PRIMARY KEY (`oid`) USING BTREE,
  INDEX `idx_uid`(`uid`) USING BTREE,
  INDEX `idx_order_index`(`order_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (16, 1, 1, '20230408220919-95', '###No2023', 2, '2023-05-12 16:20:50', NULL, '2023-04-08 23:09:41', NULL, 7.00, 0.00, 1);
INSERT INTO `order` VALUES (17, 1, 1, '20230408225945-17', '###No2023', 5, '2023-05-12 16:21:00', NULL, '2023-04-14 23:38:23', NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (18, 1, 1, '20230408230729-10', '###No2023', 5, '2023-05-12 16:21:07', NULL, '2023-04-15 18:26:52', NULL, 33.40, 0.00, 1);
INSERT INTO `order` VALUES (19, 1, 1, '20230408230829611', '###No2023', 2, '2023-05-12 16:21:24', NULL, '2023-05-12 18:21:12', NULL, 59.80, 0.00, 1);
INSERT INTO `order` VALUES (20, 1, 1, '20230409174259-17', '###No2023', 1, '2023-04-09 09:42:59', NULL, NULL, NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (21, 1, 1, '20230409230751160', '###No2023', 1, '2023-04-09 15:07:51', NULL, NULL, NULL, 239.20, 0.00, 1);
INSERT INTO `order` VALUES (22, 1, 1, '20230410000638-69', '###No2023', 1, '2023-04-17 17:22:12', NULL, NULL, NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (23, 1, 1, '20230410000931326', '###No2023', 2, '2023-05-12 16:21:34', NULL, '2023-04-10 01:10:00', NULL, 149.50, 0.00, 1);
INSERT INTO `order` VALUES (24, 1, 1, '20230410222307133', '###No2023', 4, '2023-05-12 16:21:41', NULL, '2023-04-10 23:24:34', NULL, 209.30, 0.00, 1);
INSERT INTO `order` VALUES (25, 1, 1, '20230410222730155', '###No2023', 1, '2023-04-17 17:14:27', NULL, NULL, NULL, 59.80, 0.00, 1);
INSERT INTO `order` VALUES (26, 1, 9, '20230413210221-53', '###No2023', 4, '2023-05-12 16:21:50', NULL, '2023-04-16 22:55:35', NULL, 65.30, 0.00, 1);
INSERT INTO `order` VALUES (27, 1, 9, '20230414171013193', '###No2023', 2, '2023-05-12 16:21:55', NULL, '2023-04-15 23:55:33', NULL, 59.80, 0.00, 1);
INSERT INTO `order` VALUES (28, 1, 9, '20230414231154-23', '###No2023', 5, '2023-05-12 16:22:06', '2023-04-15 23:55:32', '2023-04-16 22:55:32', NULL, 119.60, 0.00, 1);
INSERT INTO `order` VALUES (29, 1, 12, '20230415161938-96', '###No2023', 5, '2023-05-12 16:22:14', NULL, '2023-04-18 16:50:49', NULL, 66.80, 0.00, 1);
INSERT INTO `order` VALUES (30, 1, 9, '20230417172941-13', '###No2023', 5, '2023-05-12 16:22:20', NULL, '2023-04-18 17:35:24', NULL, 66.80, 0.00, 1);
INSERT INTO `order` VALUES (34, 2, 14, '20230417181115-44', '###No2023', 5, '2023-05-12 16:22:29', NULL, '2023-04-19 18:13:16', NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (35, 2, 14, '20230422144745-19', 'TestSendOut333', 4, '2023-05-12 16:23:30', NULL, '2023-05-10 22:36:19', NULL, 33.40, 0.00, 1);
INSERT INTO `order` VALUES (36, 2, 14, '20230422232038-16', '###No2023', 5, '2023-05-12 16:22:44', NULL, '2023-05-10 23:36:14', NULL, 89.70, 0.00, 1);
INSERT INTO `order` VALUES (37, 13, 15, '20230428223754-19', '###No2023', 5, '2023-05-12 16:23:22', NULL, '2023-05-10 22:16:14', NULL, 10.50, 0.00, 1);
INSERT INTO `order` VALUES (38, 13, 16, '20230429173333124', '###No2023', 5, '2023-05-12 16:23:15', NULL, '2023-05-11 22:36:14', NULL, 11.00, 0.00, 1);
INSERT INTO `order` VALUES (39, 13, 15, '20230501204028860', '###No2023', 2, '2023-05-12 16:23:13', NULL, '2023-05-10 23:36:14', NULL, 27.00, 0.00, 1);
INSERT INTO `order` VALUES (40, 13, 16, '20230501204952-13', '###No2023', 2, '2023-05-12 16:23:10', NULL, '2023-05-10 22:46:14', NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (41, 13, 15, '20230501225320281', '###No2023', 2, '2023-05-12 16:23:07', NULL, '2023-05-10 23:39:14', NULL, 29.70, 0.00, 1);
INSERT INTO `order` VALUES (42, 13, 15, '20230501225418-99', 'TestFFFFF99', 5, '2023-05-12 16:23:02', NULL, '2023-05-10 23:36:14', NULL, 3.50, 9.90, 1);
INSERT INTO `order` VALUES (45, 13, 15, '20230506174434-31', '#2023561758EE', 4, '2023-05-12 16:22:59', NULL, '2023-05-11 22:36:14', NULL, 79.70, 0.00, 1);
INSERT INTO `order` VALUES (46, 13, 16, '20230506203953223', '###No2023', 1, '2023-05-06 21:04:05', NULL, NULL, NULL, 79.70, 0.00, 1);
INSERT INTO `order` VALUES (47, 20, 17, '20230509161545303', 'TestSendGoodXXX', 4, '2023-05-12 16:00:36', NULL, '2023-05-12 07:59:21', '2023-05-12 08:00:26', 19.80, 0.00, 1);
INSERT INTO `order` VALUES (48, 20, 17, '20230512161129-11', 'TTTTTTTTTTTxxx', 3, '2023-05-12 16:15:37', NULL, '2023-05-12 08:11:58', '2023-05-12 16:15:37', 29.90, 0.00, 1);
INSERT INTO `order` VALUES (49, 21, 18, '20230513011513-20', 'XXXTenSIon', 5, '2023-05-13 01:22:44', NULL, '2023-05-13 01:19:37', '2023-05-13 01:22:11', 59.80, 0.00, 1);
INSERT INTO `order` VALUES (50, 21, 18, '20230513013515-18', 'dabianqianxi', 5, '2023-05-13 01:36:22', NULL, '2023-05-13 01:35:40', '2023-05-13 01:35:58', 10.00, 0.00, 1);
INSERT INTO `order` VALUES (51, 21, 18, '20230513013741170', 'againtestxxx', 5, '2023-05-13 01:38:49', NULL, '2023-05-13 01:38:12', '2023-05-13 01:38:33', 9.90, 0.00, 1);
INSERT INTO `order` VALUES (52, 20, 17, '20230513123351419', 'Test166666', 5, '2023-05-13 12:35:38', NULL, '2023-05-13 12:34:42', '2023-05-13 12:35:08', 67.70, 0.00, 1);
INSERT INTO `order` VALUES (53, 15, -1, '20250408002104-14', '###No2023', 1, '2025-04-08 00:21:05', NULL, NULL, NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (54, 15, -1, '20250408002702160', '###No2023', 1, '2025-04-08 00:27:03', NULL, NULL, NULL, 29.90, 0.00, 1);
INSERT INTO `order` VALUES (55, 15, -1, '20250408004920151', '11', 5, '2025-04-08 00:49:21', NULL, '2025-04-08 00:55:19', '2025-04-08 00:56:19', 1.00, 11.00, 1);
INSERT INTO `order` VALUES (56, 15, -1, '20250408195418286', '89797', 5, '2025-04-08 19:54:18', NULL, '2025-04-08 19:54:34', '2025-04-08 19:56:27', 9.00, 11.00, 1);
INSERT INTO `order` VALUES (57, 15, -1, '20250408201550622', '###No2023', 1, '2025-04-08 20:15:51', NULL, NULL, NULL, 29.90, 0.00, 1);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `oid` int(0) NOT NULL COMMENT '订单ID',
  `oitem_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单项ID',
  `gid` int(0) NOT NULL COMMENT '商品ID',
  `gpurchase_number` int(0) NOT NULL DEFAULT 1 COMMENT '购买数量',
  `gpurchase_price` decimal(10, 2) NOT NULL COMMENT '购买时单价',
  `orating_status` tinyint(0) NULL DEFAULT 0 COMMENT '评价状态：0-未评价，1-已评价',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`oitem_id`) USING BTREE,
  INDEX `idx_gid`(`gid`) USING BTREE,
  INDEX `fk_order_item_order`(`oid`) USING BTREE,
  CONSTRAINT `fk_order_item_good` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`oid`) REFERENCES `order` (`oid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (16, 21, 5, 2, 3.50, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (17, 22, 2, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (18, 23, 5, 1, 3.50, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (18, 24, 3, 1, 29.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (19, 25, 7, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (20, 26, 6, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (21, 27, 2, 3, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (21, 28, 1, 5, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (22, 29, 3, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (23, 30, 1, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (23, 31, 2, 3, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (24, 32, 1, 4, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (24, 33, 3, 3, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (25, 34, 6, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (26, 35, 4, 1, 2.00, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (26, 36, 1, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (26, 37, 3, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (26, 38, 5, 1, 3.50, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (27, 39, 1, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (28, 40, 1, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (28, 41, 2, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (29, 42, 5, 2, 3.50, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (29, 43, 2, 2, 29.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (30, 44, 5, 2, 3.50, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (30, 45, 7, 2, 29.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (34, 50, 2, 1, 29.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (35, 51, 5, 1, 3.50, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (36, 52, 2, 3, 29.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (37, 53, 5, 3, 3.50, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (38, 54, 5, 2, 3.50, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (38, 55, 4, 2, 2.00, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (39, 56, 20, 3, 9.00, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (40, 57, 2, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (35, 58, 6, 1, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (41, 59, 19, 3, 9.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (42, 60, 5, 1, 3.50, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (45, 61, 7, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (45, 62, 3, 1, 19.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (46, 63, 3, 1, 19.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (46, 64, 7, 2, 29.90, 0, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (47, 65, 17, 2, 9.90, NULL, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (48, 66, 2, 1, 29.90, NULL, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (49, 67, 2, 2, 29.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (50, 68, 24, 2, 5.00, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (51, 69, 18, 1, 9.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (52, 70, 33, 2, 4.00, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (52, 71, 3, 3, 19.90, 1, '2025-04-08 00:26:55', '2025-04-08 00:26:55');
INSERT INTO `order_item` VALUES (54, 72, 6, 1, 29.90, 0, '2025-04-08 00:27:02', '2025-04-08 00:27:02');
INSERT INTO `order_item` VALUES (55, 73, 35, 1, 1.00, 1, '2025-04-08 00:49:20', '2025-04-08 00:57:01');
INSERT INTO `order_item` VALUES (56, 74, 22, 1, 9.00, 1, '2025-04-08 19:54:18', '2025-04-08 19:57:20');
INSERT INTO `order_item` VALUES (57, 75, 8, 1, 29.90, 0, '2025-04-08 20:15:50', '2025-04-08 20:15:50');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `uid` int(0) NOT NULL COMMENT '用户ID',
  `gid` int(0) NOT NULL COMMENT '商品ID',
  `gpurchase_number` int(0) NOT NULL DEFAULT 1 COMMENT '购买数量',
  `gstatus` tinyint(0) NULL DEFAULT 1 COMMENT '状态：0-已移除，1-在购物车中',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE INDEX `uk_uid_gid`(`uid`, `gid`) USING BTREE,
  INDEX `idx_uid`(`uid`) USING BTREE,
  INDEX `idx_gid`(`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES (84, 1, 7, 3, 1, '2025-04-08 00:20:39', '2025-04-08 19:53:46');
INSERT INTO `shoppingcart` VALUES (85, 1, 5, 1, 1, '2025-04-08 00:20:39', '2025-04-08 00:20:39');
INSERT INTO `shoppingcart` VALUES (90, 15, 4, 1, 1, '2025-04-08 19:58:23', '2025-04-08 19:58:23');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '/image/avatar.jpg',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` tinyint(0) NULL DEFAULT 0 COMMENT '0-女,1-男',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `del_status` tinyint(0) NULL DEFAULT 0 COMMENT '0-正常,1-已删除',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '哈喽喽喽喽', '/image/avatar.jpg', '13197722537', 1, '2023-04-28 22:18:02', '2023-03-18 23:03:53', 0);
INSERT INTO `user` VALUES (2, 'hhh', '123456', '测试3', '/image/avatar.jpg', '10000', 1, '2025-03-20 15:24:32', '2023-04-28 17:56:57', 0);
INSERT INTO `user` VALUES (3, 'xxx1', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:03:07', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (4, 'xxx2', 'xxx', 'EEEEEE呃呃呀', '/image/avatar.jpg', '10001', 1, '2023-05-13 11:51:34', '2023-04-28 18:14:21', 1);
INSERT INTO `user` VALUES (5, 'xxx3', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-05-02 01:30:51', '2023-04-28 18:14:21', 1);
INSERT INTO `user` VALUES (6, 'xxx4', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:03:09', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (7, 'xxx5', 'xxx', 'xxx', '/image/avatar.jpg', '123321aa', 0, '2023-04-28 22:03:13', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (8, 'xxx6', 'xxx', 'xxxaa', '/image/avatar.jpg', '10001', 0, '2023-05-02 01:22:10', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (9, 'xxx7', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:41:37', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (10, 'xxx8', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:03:13', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (11, 'xxx9', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:03:13', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (12, 'xxx10', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:03:13', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (13, 'weilong', '123456', '韦龙', '/image/avatar.jpg', '13197722538', 1, '2023-05-02 01:44:16', '2023-04-28 18:14:34', 0);
INSERT INTO `user` VALUES (14, 'add', 'add', 'add', '/image/avatar.jpg', 'add', 1, '2023-04-28 22:29:44', '2023-04-28 13:26:43', 0);
INSERT INTO `user` VALUES (15, 'a', 'aa', 'a', '/image/avatar.jpg', 'a', 1, '2023-04-28 22:29:45', '2023-04-28 13:38:05', 0);
INSERT INTO `user` VALUES (16, 'cc', 'cc', 'bb', '/image/avatar.jpg', 'bb', 1, '2023-04-28 22:29:45', '2023-04-28 13:57:34', 0);
INSERT INTO `user` VALUES (17, 'abcdefg', '123456', '哈哈哈', '/image/avatar.jpg', '13197722537', 1, '2023-04-28 22:41:21', '2023-04-28 14:27:28', 0);
INSERT INTO `user` VALUES (18, 'xxx8', 'xxx', 'xxx', '/image/avatar.jpg', '10001', 0, '2023-04-28 22:41:37', '2023-04-28 18:14:21', 0);
INSERT INTO `user` VALUES (19, 'aaaaaaaaaqqq', 'asda', '最新', '/image/avatar.jpg', '11111000', 1, '2023-05-12 15:46:21', '2023-05-01 17:24:55', 0);
INSERT INTO `user` VALUES (20, '13197722537', '13197722537', '韦', '/image/imgacd3339c0f214b8eac2c3e03c0a6a283.JPG', '13197722537', 1, '2023-05-12 15:46:22', '2023-05-08 06:44:15', 0);
INSERT INTO `user` VALUES (21, '13197722538', '13197722538', '韦同学k', '/image/img63104ef387a442f7a209a6474976d3a8.JPG', '13197722538', 1, '2023-05-13 01:28:36', '2023-05-13 01:14:00', 0);
INSERT INTO `user` VALUES (22, 'test338', '123456', 'test', '/image/avatar.jpg', '13197722533', 1, '2023-05-13 01:28:37', '2023-05-13 01:28:08', 0);
INSERT INTO `user` VALUES (23, 'qianxi666', '123456', '前夕', '/image/avatar.jpg', '13197722555', 1, '2023-05-13 01:42:16', '2023-05-13 01:40:17', 0);
INSERT INTO `user` VALUES (24, 'qianxi3', '123456', '前夕3399', '/image/avatar.jpg', '13197722531', 0, '2023-05-13 01:42:54', '2023-05-13 01:42:42', 0);

SET FOREIGN_KEY_CHECKS = 1;
