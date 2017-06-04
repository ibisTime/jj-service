package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 资质
* @author: shan
* @since: 2017年06月04日
* @history:
*/
public class Qualify extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 类别
	private String type;

	// 名字
	private String name;

	// 描述
	private String description;

	// 状态
	private String status;

	// 最后修改人
	private String updater;

	// 最后修改时间
	private String updateDatetime;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getUpdateDatetime() {
		return updateDatetime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}