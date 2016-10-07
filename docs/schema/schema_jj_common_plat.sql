/*
 Navicat MySQL Data Transfer

 Source Server         : 148
 Source Server Version : 50545
 Source Host           : 121.43.101.148
 Source Database       : jj_common_plat

 Target Server Version : 50545
 File Encoding         : utf-8

 Date: 10/07/2016 15:10:56 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tcp_demand`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_demand`;
CREATE TABLE `tcp_demand` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `quality_code` varchar(32) DEFAULT NULL COMMENT '资质编号',
  `exp_company` varchar(32) DEFAULT NULL COMMENT '意向企业(空 所有公司，其他公司编号)',
  `urgent_level` varchar(4) DEFAULT NULL COMMENT '紧急程度(1 紧急 0 不紧急)',
  `description` text COMMENT '需求说明',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 正常 0 违规)',
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布用户编号',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `deal_user` varchar(32) DEFAULT NULL COMMENT '处理人',
  `deal_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理意见',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_intention`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_intention`;
CREATE TABLE `tcp_intention` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 职位申请 2 感兴趣关系)',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 已申请 2 已完成)',
  `to_code` varchar(32) DEFAULT NULL COMMENT '服务编号',
  `from_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `from_role` varchar(32) DEFAULT NULL COMMENT '用什么东西申请(简历)',
  `from_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `deal_user` varchar(32) DEFAULT NULL COMMENT '处理人',
  `deal_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理意见',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_position`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_position`;
CREATE TABLE `tcp_position` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '职位名称',
  `kind` varchar(4) DEFAULT NULL COMMENT '种类',
  `province` varchar(255) DEFAULT NULL COMMENT '工作地址(省)',
  `city` varchar(255) DEFAULT NULL COMMENT '工作地址(市)',
  `experience` varchar(4) DEFAULT NULL COMMENT '工作经历(1 1年内/2 1-3年/3 3-5年/4 5年以上)',
  `education` varchar(4) DEFAULT NULL COMMENT '学历(1 本科 2 大专 3 高中 4 其他)',
  `type` varchar(4) DEFAULT NULL COMMENT '工作类型(1 全职 2兼职 3实习)',
  `job_num` int(11) DEFAULT NULL COMMENT '招聘人数',
  `msalary` varchar(255) DEFAULT NULL COMMENT '月薪',
  `description` text COMMENT '职位描述',
  `company_code` varchar(32) DEFAULT NULL COMMENT '所属公司',
  `is_hot` varchar(4) DEFAULT NULL COMMENT '是否热门',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 正常 0 违规)',
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `dealer` varchar(32) DEFAULT NULL COMMENT '处理人',
  `deal_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理意见',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_resume`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_resume`;
CREATE TABLE `tcp_resume` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '简历名称',
  `is_work` char(1) DEFAULT NULL COMMENT '是否有工作经验',
  `pre_comp_name` varchar(64) DEFAULT NULL COMMENT '最近公司名称',
  `pre_pos_name` varchar(64) DEFAULT NULL COMMENT '最近职位名称',
  `pre_work_time` varchar(255) DEFAULT NULL COMMENT '最近工作时间',
  `pre_msalary` varchar(255) DEFAULT NULL COMMENT '最近月薪',
  `pre_description` text COMMENT '最近职位描述',
  `education` varchar(4) DEFAULT NULL COMMENT '学历(1 本科 2 大专 3 高中 4 其他)',
  `is_tz` varchar(4) DEFAULT NULL COMMENT '是否统招(1 是 0 否)',
  `study_time` varchar(255) DEFAULT NULL COMMENT '就读时间',
  `school` varchar(255) DEFAULT NULL COMMENT '学校名称',
  `profession` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `type` varchar(4) DEFAULT NULL COMMENT '工作类型（1 全职 2 兼职 3实习）',
  `exp_position` varchar(255) DEFAULT NULL COMMENT '期望岗位(A 运营主管 B 运营总监 C 设计/美工 D 客服/售后 E 仓储管理 F 推广)',
  `exp_msalary` varchar(255) DEFAULT NULL COMMENT '期望月薪',
  `exp_province` varchar(255) DEFAULT NULL COMMENT '期望工作地点(省)',
  `exp_city` varchar(255) DEFAULT NULL COMMENT '期望工作地点(市)',
  `work_status` varchar(4) DEFAULT NULL COMMENT '工作状态(1 已离职，可直接上岗，2 未离职，需一段时间)',
  `is_open` varchar(4) DEFAULT NULL COMMENT '是否公开(1 公开 0 公开)',
  `use_times` int(11) DEFAULT NULL COMMENT '使用次数',
  `status` varchar(45) DEFAULT NULL COMMENT '状态(1 正常 0 违规)',
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `dealer` varchar(32) DEFAULT NULL COMMENT '处理人',
  `deal_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '违规说明',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve`;
CREATE TABLE `tcp_serve` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '服务名称',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `quote_min` bigint(20) DEFAULT NULL COMMENT '报价最小值',
  `quote_max` bigint(20) DEFAULT NULL COMMENT '报价最大值',
  `quality_code` varchar(32) DEFAULT NULL COMMENT '资质编号',
  `description` text COMMENT '详细描述',
  `is_hot` varchar(4) DEFAULT NULL COMMENT '是否热门(1 是 0 否)',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(45) DEFAULT NULL COMMENT '状态（1 正常 0 违规）',
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `dealer` varchar(32) DEFAULT NULL COMMENT '处理人',
  `deal_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理意见',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_art`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_art`;
CREATE TABLE `tcp_serve_art` (
  `serve_code` varchar(32) NOT NULL COMMENT '编号',
  `design_num` int(11) DEFAULT NULL COMMENT '设计师人数',
  `sclm` varchar(255) DEFAULT NULL COMMENT '擅长类目',
  `home_days` int(11) DEFAULT NULL COMMENT '首页天数',
  `home_price` bigint(20) DEFAULT NULL COMMENT '首页价格',
  `detail_days` int(11) DEFAULT NULL COMMENT '详情页天数',
  `detail_price` bigint(20) DEFAULT NULL COMMENT '详情页价格',
  `banner_days` int(11) DEFAULT NULL COMMENT '海报图天数',
  `banner_price` bigint(20) DEFAULT NULL COMMENT '海报图价格',
  `all_days` int(11) DEFAULT NULL COMMENT '全店设计天数',
  `all_price` bigint(20) DEFAULT NULL COMMENT '全店设计价格',
  `works` varchar(255) DEFAULT NULL COMMENT '作品案例',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_cp`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_cp`;
CREATE TABLE `tcp_serve_cp` (
  `serve_code` varchar(32) NOT NULL COMMENT '编号',
  `ck_num` int(11) DEFAULT NULL COMMENT '仓库个数',
  `ck_area` varchar(255) DEFAULT NULL COMMENT '仓库面积',
  `goods_kind` varchar(4) DEFAULT NULL COMMENT '支持货品种类(1食物 2海鲜 3生活用品)',
  `dsend_num` int(11) DEFAULT NULL COMMENT '日平均发货能力（单）',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_cyy`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_cyy`;
CREATE TABLE `tcp_serve_cyy` (
  `serve_code` varchar(32) NOT NULL COMMENT '编号',
  `bg_area` bigint(20) DEFAULT NULL COMMENT '办公面积',
  `avail_bg_area` bigint(20) DEFAULT NULL COMMENT '剩余办公面积',
  `cc_area` bigint(20) DEFAULT NULL COMMENT '仓储总面积',
  `avail_cc_area` bigint(20) DEFAULT NULL COMMENT '可用仓储总面积',
  `zzfw` varchar(255) DEFAULT NULL COMMENT '增值服务(A 人才培训 B 代理运营 C 软件系统开发 D 营销广告 E 渠道推广 F 仓储物流)',
  `introduce` text COMMENT '产业园详细介绍',
  `yh_policy` text COMMENT '优惠政策',
  `pic1` varchar(255) DEFAULT NULL COMMENT '产业园照片1',
  `pic2` varchar(255) DEFAULT NULL COMMENT '产业园照片2',
  `description` text COMMENT '详细描述',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_kfwb`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_kfwb`;
CREATE TABLE `tcp_serve_kfwb` (
  `serve_code` varchar(32) NOT NULL COMMENT '编号',
  `kf_num` int(11) DEFAULT NULL COMMENT '设计师人数',
  `mtrade_amount` varchar(255) DEFAULT NULL COMMENT '线上月均交易额',
  `business` varchar(4) DEFAULT NULL COMMENT '客服业务(1 售前 2售后)',
  `fee_mode` varchar(4) DEFAULT NULL COMMENT '收费模式(1 服务费+提成 2 服务费 3 提成)',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_photo`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_photo`;
CREATE TABLE `tcp_serve_photo` (
  `serve_code` varchar(32) NOT NULL COMMENT '服务编号',
  `py_num` int(11) DEFAULT NULL COMMENT '棚影数量',
  `sys_num` int(11) DEFAULT NULL COMMENT '摄影师数量',
  `is_dz` varchar(4) DEFAULT NULL COMMENT '是否定制需求(1 是 0 否)',
  `scpslm` varchar(255) DEFAULT NULL COMMENT '擅长拍摄类目',
  `works` varchar(255) DEFAULT NULL COMMENT '上传代表作品',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_shop`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_shop`;
CREATE TABLE `tcp_serve_shop` (
  `serve_code` varchar(32) NOT NULL COMMENT '编号',
  `tgfw` varchar(32) DEFAULT NULL COMMENT '提供服务',
  `fee_mode` varchar(4) DEFAULT NULL COMMENT '收费模式',
  `pay_cycle` varchar(4) DEFAULT NULL COMMENT '付款周期',
  `scyylm` varchar(255) DEFAULT NULL COMMENT '擅长运营类目',
  `suc_case` varchar(255) DEFAULT NULL COMMENT '成功案例展示',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tcp_serve_train`
-- ----------------------------
DROP TABLE IF EXISTS `tcp_serve_train`;
CREATE TABLE `tcp_serve_train` (
  `serve_code` varchar(32) NOT NULL COMMENT '编号',
  `lector_num` int(11) DEFAULT NULL COMMENT '讲师总人数',
  `mtrain_times` int(11) DEFAULT NULL COMMENT '月均培训场次',
  `mtrain_num` int(11) DEFAULT NULL COMMENT '月均培训人数',
  `resume1` varchar(255) DEFAULT NULL COMMENT '第一位讲师简历',
  `resume2` varchar(255) DEFAULT NULL COMMENT '第二位讲师简历',
  `resume3` varchar(255) DEFAULT NULL COMMENT '第三位讲师简历',
  `course` varchar(255) DEFAULT NULL COMMENT '培训课程',
  PRIMARY KEY (`serve_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;