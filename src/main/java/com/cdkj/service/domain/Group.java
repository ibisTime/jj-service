package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 组
* @author: shan
* @since: 2017年06月04日
* @history:
*/
public class Group extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 名称
	private String name;

	// 关注数量
	private String focusNum;

	// 创建日期
	private String createDatetime;

	// 用户编号
	private String userId;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setFocusNum(String focusNum) {
		this.focusNum = focusNum;
	}

	public String getFocusNum() {
		return focusNum;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}