

DROP TABLE IF EXISTS `tmoom_business`;
CREATE TABLE `tmoom_business` (
  `code` varchar(32) NOT NULL COMMENT '业务编号',
  `name` varchar(64) NOT NULL COMMENT '业务名称',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `principal` bigint(32) NOT NULL COMMENT '业务本金',
  `profit` bigint(32) NOT NULL COMMENT '业务收益',
  `hsb_url` varchar(255) NOT NULL COMMENT '核算表附件',
  `hspz_url` varchar(255) NOT NULL COMMENT '核算凭证附件',
  `fj_url` varchar(255) NOT NULL COMMENT '附件',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `apply_user` varchar(32) NOT NULL COMMENT '申请人',
  `apply_datetime` datetime NOT NULL COMMENT '申请时间',
  `check_user` varchar(32) DEFAULT NULL COMMENT '审核人',
  `check_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `subject_code` varchar(32) NOT NULL COMMENT '项目编号',
  `visual` char(1) NOT NULL COMMENT '是否可见',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_business_table`;
CREATE TABLE `tmoom_business_table` (
  `type` varchar(2) NOT NULL COMMENT '类型(收入/支出/收益)',
  `dkey` varchar(64) NOT NULL COMMENT '条目',
  `dvalue` varchar(255) NOT NULL COMMENT '条目值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_datetime` datetime DEFAULT NULL,
  `business_code` varchar(32) NOT NULL COMMENT '业务编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_contract`;
CREATE TABLE `tmoom_contract` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `subject_code` varchar(32) NOT NULL COMMENT '项目编号',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `type` char(1) NOT NULL COMMENT '类型',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电子合同表';


DROP TABLE IF EXISTS `tmoom_gjs_account`;
CREATE TABLE `tmoom_gjs_account` (
  `account_number` varchar(32) NOT NULL COMMENT '账号',
  `status` varchar(2) NOT NULL COMMENT '状态(0正常,1程序锁定,2人工锁定)',
  `amount` bigint(32) NOT NULL COMMENT '余额（厘）',
  `frozen_amount` bigint(32) NOT NULL COMMENT '冻结金额（厘）',
  `currency` varchar(8) NOT NULL COMMENT '币种',
  `md5` varchar(32) NOT NULL COMMENT 'MD5值',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_gjs_account_jour`;
CREATE TABLE `tmoom_gjs_account_jour` (
  `aj_no` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `biz_type` varchar(4) NOT NULL COMMENT '业务类型',
  `ref_no` varchar(32) NOT NULL COMMENT '关联单号',
  `trans_amount` bigint(32) NOT NULL COMMENT '发生金额（有正负之分）',
  `pre_amount` bigint(32) NOT NULL COMMENT '发生前金额',
  `post_amount` bigint(32) NOT NULL COMMENT '发生后金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `work_date` varchar(8) NOT NULL COMMENT '理应对账时间',
  `check_user` varchar(32) DEFAULT NULL COMMENT '对账人（li为程序）',
  `check_datetime` datetime DEFAULT NULL COMMENT ' 对账时间',
  `account_number` varchar(32) NOT NULL COMMENT '账号',
  PRIMARY KEY (`aj_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_invest`;
CREATE TABLE `tmoom_invest` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(2) NOT NULL COMMENT '类型',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `project_code` varchar(32) NOT NULL COMMENT '标的编号',
  `user_id` varchar(32) NOT NULL COMMENT '投资用户编号',
  `real_name` varchar(64) NOT NULL COMMENT '投资用户姓名',
  `now_amount` bigint(20) DEFAULT NULL COMMENT '投资时有的金额(描述一种状态)',
  `now_note` varchar(255) DEFAULT NULL COMMENT '投资时有的说明(描述一种状态)',
  `invest_amount` bigint(20) DEFAULT NULL COMMENT '投资金额',
  `invest_note` varchar(255) DEFAULT NULL COMMENT '投资说明',
  `invest_datetime` datetime NOT NULL COMMENT '投资时间',
  `check_datetime` datetime DEFAULT NULL COMMENT '确认认购时间',
  `subject_code` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `may_profit` bigint(20) DEFAULT NULL COMMENT '预计收益',
  `contract_no` varchar(32) DEFAULT NULL COMMENT '合同编号',
  `lxstart_datetime` datetime DEFAULT NULL COMMENT '正常利息开始时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tmoom_invest_table`;
CREATE TABLE `tmoom_invest_table` (
  `code` varchar(32) NOT NULL COMMENT '流水编号',
  `amount` bigint(32) NOT NULL COMMENT '金额（厘）',
  `money_datetime` datetime DEFAULT NULL COMMENT '到款时间',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `invest_code` varchar(32) NOT NULL COMMENT '认购编号',
  `from_user` varchar(32) NOT NULL COMMENT '来方',
  `from_type` char(1) NOT NULL COMMENT '类型(对公对私)',
  `from_bank_code` varchar(8) DEFAULT NULL COMMENT '银行行号',
  `from_bank_name` varchar(32) DEFAULT NULL COMMENT '银行名称',
  `from_subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `from_bankcard_no` varchar(64) NOT NULL COMMENT '银行卡编号',
  `to_user` varchar(32) NOT NULL COMMENT '受方',
  `to_type` char(1) NOT NULL COMMENT '类型(对公对私)',
  `to_bank_code` varchar(8) DEFAULT NULL COMMENT '银行行号',
  `to_bank_name` varchar(32) DEFAULT NULL COMMENT '银行名称',
  `to_subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `to_bankcard_no` varchar(64) NOT NULL COMMENT '银行卡编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_project`;
CREATE TABLE `tmoom_project` (
  `code` varchar(32) NOT NULL COMMENT '项目编号',
  `name` varchar(255) NOT NULL COMMENT '项目名称',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `serve` varchar(2) NOT NULL COMMENT '服务类型',
  `quote` varchar(2) NOT NULL COMMENT '报价模式',
  `quote_value1` decimal(18,8) NOT NULL COMMENT '报价具体值',
  `quote_value2` decimal(18,8) DEFAULT NULL,
  `level` int(11) NOT NULL COMMENT '受众等级',
  `total_amount` bigint(20) NOT NULL COMMENT '总金额(绝对值)',
  `period` int(11) DEFAULT NULL COMMENT '期限',
  `type` varchar(2) NOT NULL COMMENT '类型(额度/期限)',
  `amount` bigint(32) NOT NULL COMMENT '额度/募集金额(绝对值)',
  `loaned_amount` bigint(32) DEFAULT NULL COMMENT '已经借到金额(绝对值):初始为0',
  `trader` varchar(32) NOT NULL COMMENT '操盘手',
  `trader_name` varchar(64) NOT NULL COMMENT '操盘手名字',
  `summary` text NOT NULL COMMENT '概述',
  `description` text NOT NULL COMMENT '描述',
  `mjstart_datetime` datetime DEFAULT NULL COMMENT '募集开始时间',
  `mjend_datetime` datetime DEFAULT NULL COMMENT '募集结束时间',
  `min_invest_amount` bigint(20) NOT NULL COMMENT '最小投资金额（绝对值）',
  `invest_amount_step` bigint(20) NOT NULL COMMENT '递增投资金额（绝对值）',
  `max_invest_amount` bigint(20) NOT NULL COMMENT '单笔最大投资金额（绝对值）',
  `contract_template` bigint(20) NOT NULL COMMENT '合同类型id',
  `repay_datetime` datetime DEFAULT NULL COMMENT '还款时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '满标时间',
  `apply_user` varchar(32) NOT NULL COMMENT '发起人',
  `apply_datetime` datetime NOT NULL COMMENT '发起时间',
  `check_user` varchar(32) DEFAULT NULL COMMENT '初审人',
  `check_datetime` datetime DEFAULT NULL COMMENT '初审时间',
  `check_note` varchar(255) DEFAULT NULL COMMENT '初核结果说明',
  `recheck_user` varchar(32) DEFAULT NULL COMMENT '复审人',
  `recheck_datetime` datetime DEFAULT NULL COMMENT '复审时间',
  `recheck_note` varchar(255) DEFAULT NULL COMMENT '复审结果说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `pictures` varchar(255) DEFAULT NULL COMMENT '项目图片 可以上传多张,分号隔开（预留）',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标的表';


DROP TABLE IF EXISTS `tmoom_repay_plan`;
CREATE TABLE `tmoom_repay_plan` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(2) NOT NULL COMMENT '类别',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `real_name` varchar(64) NOT NULL COMMENT '用户姓名',
  `repay_datetime` datetime NOT NULL COMMENT '还款时间',
  `repay_principal` bigint(32) NOT NULL COMMENT '本金',
  `repay_profit` bigint(32) NOT NULL COMMENT '收益',
  `fee` bigint(32) NOT NULL COMMENT '手续费',
  `real_repay_datetime` datetime DEFAULT NULL COMMENT '实还还款时间',
  `real_repay_principal` bigint(32) DEFAULT NULL COMMENT '实还本金',
  `real_repay_profit` bigint(32) DEFAULT NULL COMMENT '实还收益',
  `real_fee` bigint(32) DEFAULT NULL COMMENT '实还手续费',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `invest_code` varchar(32) NOT NULL COMMENT '投资编号',
  `business_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `subject_code` varchar(32) NOT NULL COMMENT '项目编号',
  `business_profit` bigint(32) NOT NULL COMMENT '业务收益',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_subject`;
CREATE TABLE `tmoom_subject` (
  `code` varchar(32) NOT NULL COMMENT '项目编号',
  `type` varchar(2) NOT NULL COMMENT '项目类型 额度/期限',
  `status` varchar(2) NOT NULL COMMENT '项目状态',
  `total_amount` bigint(32) DEFAULT NULL COMMENT '项目总金额（5亿）',
  `total_principal` bigint(32) DEFAULT NULL COMMENT '本金',
  `total_profit` bigint(32) DEFAULT NULL COMMENT '收益',
  `name` varchar(64) NOT NULL COMMENT '项目名称',
  `serve` varchar(2) NOT NULL COMMENT '服务类型',
  `quote` varchar(2) NOT NULL COMMENT '报价模式',
  `quote_value1` decimal(18,8) NOT NULL COMMENT '报价具体值',
  `quote_value2` decimal(18,8) DEFAULT NULL,
  `level` int(11) NOT NULL COMMENT '受众等级',
  `trader` varchar(32) NOT NULL COMMENT '操盘手',
  `trader_name` varchar(64) NOT NULL COMMENT '操盘手名字',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间（手工开始）',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间（手工结束）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `project_code` varchar(32) DEFAULT NULL COMMENT '标的编号',
  PRIMARY KEY (`code`),
  UNIQUE KEY `project_code_UNIQUE` (`project_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tmoom_trader`;
CREATE TABLE `tmoom_trader` (
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `company_id` varchar(32) NOT NULL COMMENT '所在公司',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_kind` char(1) NOT NULL COMMENT '证件类型',
  `id_no` varchar(32) NOT NULL COMMENT '证件号',
  `real_name` varchar(16) NOT NULL COMMENT '真实姓名',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `introduction` text COMMENT '简介',
  `trade_pwd` varchar(32) DEFAULT NULL COMMENT '交易密码',
  `trade_pwd_strength` char(1) NOT NULL COMMENT '交易密码强度',
  `level` char(1) DEFAULT NULL COMMENT '等级',
  `total_volume` varchar(255) DEFAULT NULL COMMENT '累计操盘金额',
  `total_count` varchar(255) DEFAULT NULL COMMENT '累计操盘数',
  `total_profit` varchar(255) DEFAULT NULL COMMENT '累计收益',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` varchar(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操盘手';
