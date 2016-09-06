/*
 Navicat MySQL Data Transfer

 Source Server         : 148
 Source Server Version : 50545
 Source Host           : 121.43.101.148
 Source Database       : develop_mall

 Target Server Version : 50545
 File Encoding         : utf-8

 Date: 07/25/2016 22:47:16 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tmall_address`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_address`;
CREATE TABLE `tmall_address` (
  `code` varchar(32) NOT NULL COMMENT '收件编号',
  `addressee` varchar(64) DEFAULT NULL COMMENT '收件人姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `district` varchar(64) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `is_default` char(1) DEFAULT NULL COMMENT '是否默认地址',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_buy_guide`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_buy_guide`;
CREATE TABLE `tmall_buy_guide` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `model_code` VARCHAR(32) NULL DEFAULT NULL COMMENT '型号编号',
  `cost_price` BIGINT(20) NULL DEFAULT NULL COMMENT '成本价',
  `from_user` VARCHAR(32) NULL DEFAULT NULL COMMENT '对应货品商',
  `from_quantity` INT(11) NULL DEFAULT NULL COMMENT '仓库数量',
  `from_site` VARCHAR(4) NULL DEFAULT NULL COMMENT '仓库位置（预留）',
  `to_level` VARCHAR(4) NULL DEFAULT NULL COMMENT '针对用户等级',
  `original_price` BIGINT(20) NULL DEFAULT NULL COMMENT '原价',
  `discount_price` BIGINT(20) NULL DEFAULT NULL COMMENT '折扣价',
  `cny_price` BIGINT(20) NULL DEFAULT NULL COMMENT '人民币价格',
  `to_site` VARCHAR(4) NULL DEFAULT NULL COMMENT '线上位置',
  `status` VARCHAR(4) NULL DEFAULT NULL COMMENT '状态',
  `updater` VARCHAR(32) NULL DEFAULT NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_cart`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_cart`;
CREATE TABLE `tmall_cart` (
  `code` varchar(32) NOT NULL COMMENT '购物车编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `model_code` varchar(32) DEFAULT NULL COMMENT '型号编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_goods`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_goods`;
CREATE TABLE `tmall_goods` (
  `code` varchar(255) NOT NULL COMMENT '编号',
  `cost_price` bigint(20) NOT NULL COMMENT '成本价',
  `sale_price` bigint(20) NOT NULL COMMENT '零售价',
  `model_code` varchar(32) NOT NULL COMMENT '型号编号',
  `logistics_code` varchar(32) NOT NULL COMMENT '关联的物流单号',
  `user_id` varchar(32) NOT NULL COMMENT '货关联的用户ID',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_goods_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_goods_order`;
CREATE TABLE `tmall_goods_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `goods_code` varchar(32) DEFAULT NULL COMMENT '货品编号',
  `price` bigint(20) DEFAULT NULL COMMENT '单价',
  `quantity` bigint(20) DEFAULT NULL COMMENT '数量',
  `status` varchar(2) DEFAULT NULL COMMENT '状态、0 待发布 1已发布，2已过期',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请备注',
  `approve_user` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_note` varchar(45) DEFAULT NULL COMMENT '审核说明',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_integral`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_integral`;
CREATE TABLE `tmall_integral` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '积分商用户编号',
  `quantity` bigint(20) DEFAULT NULL COMMENT '积分数量',
  `price` bigint(20) DEFAULT NULL COMMENT '价格,相对现金',
  `is_approve` char(1) DEFAULT NULL COMMENT '是否审批 1需要，0不需要',
  `status` varchar(4) DEFAULT NULL COMMENT '状态、1 上架  0 下架',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_invoice`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_invoice`;
CREATE TABLE `tmall_invoice` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(4) NULL DEFAULT NULL COMMENT '类型',
  `apply_user` VARCHAR(32) NULL DEFAULT NULL COMMENT '下单人',
  `address_code` VARCHAR(32) NULL DEFAULT NULL COMMENT '收货信息编号',
  `apply_note` VARCHAR(255) NULL DEFAULT NULL COMMENT '下单备注',
  `apply_datetime` DATETIME NULL DEFAULT NULL COMMENT '下单时间',
  `receipt_type` VARCHAR(4) NULL DEFAULT NULL COMMENT '发票类型(1 个人，2 企业)',
  `receipt_title` VARCHAR(32) NULL DEFAULT NULL COMMENT '发票抬头',
  `pay_amount` BIGINT(20) NULL DEFAULT NULL COMMENT '实际支付金额',
  `pay_cny_amount` BIGINT(20) NULL DEFAULT NULL COMMENT '实际支付人民币金额',
  `status` VARCHAR(4) NULL DEFAULT NULL COMMENT '状态',
  `approve_user` VARCHAR(32) NULL DEFAULT NULL COMMENT '反馈人',
  `approve_datetime` DATETIME NULL DEFAULT NULL COMMENT '反馈时间',
  `approve_note` VARCHAR(255) NULL DEFAULT NULL COMMENT '反馈说明',
  `to_user` VARCHAR(32) NULL DEFAULT NULL COMMENT '向谁要货',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_invoice_model`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_invoice_model`;
CREATE TABLE `tmall_invoice_model` (
  `code` VARCHAR(32) NOT NULL COMMENT '',
  `invoice_code` VARCHAR(32) NULL DEFAULT NULL COMMENT '发货单号',
  `model_code` VARCHAR(32) NULL DEFAULT NULL COMMENT '型号编号',
  `quantity` INT(11) NULL DEFAULT NULL COMMENT '数量',
  `sale_price` BIGINT(20) NULL DEFAULT NULL COMMENT '零售价',
  `sale_cny_price` BIGINT(20) NULL DEFAULT NULL COMMENT '人民币价格',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_logistics`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_logistics`;
CREATE TABLE `tmall_logistics` (
  `code` varchar(32) NOT NULL COMMENT '物流单号',
  `invoice_code` varchar(32) DEFAULT NULL COMMENT '物流单关联的发货单号',
  `company` varchar(32) DEFAULT NULL COMMENT '物流公司编号',
  `deliverer` varchar(32) DEFAULT NULL COMMENT '发货人编号',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `pdf` varchar(255) DEFAULT NULL COMMENT '物流单',
  `user_id` varchar(32) DEFAULT NULL COMMENT '物流单关联的用户ID',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（1 发货中，2 确认收货）',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_mer_card`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_mer_card`;
CREATE TABLE `tmall_mer_card` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `company_code` varchar(32) NOT NULL COMMENT '公司编号',
  `subbranch` varchar(255) NOT NULL COMMENT '开户支行',
  `card_no` varchar(64) NOT NULL COMMENT '账号',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `updater` varchar(32) NOT NULL COMMENT '更新人',
  `update_datetime` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_model`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_model`;
CREATE TABLE `tmall_model` (
  `code` varchar(32) NOT NULL COMMENT '型号编号',
  `name` varchar(64) DEFAULT NULL COMMENT '型号名称',
  `pic1` varchar(255) DEFAULT NULL COMMENT '图1',
  `pic2` varchar(255) DEFAULT NULL COMMENT '图2',
  `pic3` varchar(255) DEFAULT NULL COMMENT '图3',
  `description` text COMMENT '文本',
  `product_code` varchar(32) DEFAULT NULL COMMENT '所属产品编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_model_specs`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_model_specs`;
CREATE TABLE `tmall_model_specs` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `model_code` varchar(32) DEFAULT NULL COMMENT '所属型号编号',
  `dkey` varchar(64) DEFAULT NULL COMMENT '规格参数名',
  `dvalue` varchar(255) DEFAULT NULL COMMENT '规格参数值',
  `order_num` int(4) DEFAULT NULL COMMENT '顺序',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_product`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product`;
CREATE TABLE `tmall_product` (
  `code` varchar(32) NOT NULL COMMENT '产品编号',
  `category` varchar(4) DEFAULT NULL COMMENT '大类',
  `type` varchar(4) DEFAULT NULL COMMENT '小类',
  `type_pic` varchar(255) DEFAULT NULL COMMENT '小类图片',
  `order_no` int(4) DEFAULT NULL COMMENT 'UI次序',
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `adv_title` varchar(255) DEFAULT NULL COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `major_pic` varchar(255) DEFAULT NULL COMMENT '主推产品图',
  `major_text` varchar(255) DEFAULT NULL COMMENT '主推产品介绍文本',
  `family_pic` varchar(255) DEFAULT NULL COMMENT '全家福图',
  `family_text` varchar(255) DEFAULT NULL COMMENT '全家福文本',
  `highlight_pic` varchar(255) DEFAULT NULL COMMENT '亮点图',
  `highlight_text` varchar(255) DEFAULT NULL COMMENT '亮点文本',
  `status` varchar(4) DEFAULT NULL COMMENT '产品状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_repair_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_repair_order`;
CREATE TABLE `tmall_repair_order` (
  `code` varchar(32) NOT NULL COMMENT '维修单编号',
  `goods_code` varchar(255) NOT NULL COMMENT '维修单关联的货编号',
  `model_name` varchar(64) NOT NULL COMMENT '所属型号',
  `product_name` varchar(64) NOT NULL COMMENT '所属产品',
  `user_id` varchar(32) NOT NULL,
  `apply_user` varchar(32) NOT NULL COMMENT '申请人',
  `contact` varchar(32) NOT NULL COMMENT '申请人联系方式',
  `apply_reason` text NOT NULL COMMENT '申请维修理由',
  `apply_datetime` datetime NOT NULL COMMENT '申请时间',
  `status` varchar(2) NOT NULL COMMENT '维修单状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_sale_guide`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_sale_guide`;
CREATE TABLE `tmall_sale_guide` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `model_code` varchar(32) DEFAULT NULL COMMENT '型号编号',
  `to_level` varchar(4) DEFAULT NULL COMMENT '用户等级',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` bigint(20) DEFAULT NULL COMMENT '价格',
  `updater` varchar(45) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_config`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_config`;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `to_system` varchar(8) NOT NULL COMMENT '针对系统',
  `ckey` varchar(32) NOT NULL COMMENT 'key值',
  `cvalue` varchar(255) NOT NULL COMMENT '值',
  `note` varchar(255) DEFAULT NULL COMMENT '配置说明',
  `updater` varchar(32) NOT NULL COMMENT '更新人',
  `update_datetime` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_contract_template`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_contract_template`;
CREATE TABLE `tsys_contract_template` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号 PK',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `type` varchar(4) NOT NULL COMMENT '类别',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同表';

-- ----------------------------
--  Table structure for `tsys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `to_system` varchar(8) NOT NULL COMMENT '针对系统',
  `type` char(1) NOT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父key',
  `dkey` varchar(32) NOT NULL COMMENT 'key',
  `dvalue` varchar(64) NOT NULL COMMENT '值',
  `updater` varchar(32) NOT NULL COMMENT '更新人',
  `update_datetime` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_log`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_log`;
CREATE TABLE `tsys_log` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `to_system` varchar(8) NOT NULL COMMENT '针对系统',
  `to_table` varchar(32) NOT NULL COMMENT '针对表',
  `to_row` varchar(32) DEFAULT NULL COMMENT '针对记录',
  `to_column` varchar(255) DEFAULT NULL COMMENT '针对字段',
  `operate_type` varchar(8) NOT NULL COMMENT '操作类型',
  `pre_value` varchar(255) DEFAULT NULL COMMENT '变更前值',
  `post_value` varchar(255) DEFAULT NULL COMMENT '变更后值',
  `operater` varchar(32) NOT NULL COMMENT '操作人',
  `operate_datetime` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
