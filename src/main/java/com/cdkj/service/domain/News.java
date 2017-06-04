package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 资讯
* @author: shan
* @since: 2017年06月04日
* @history:
*/
public class News extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 类型
	private String type;

	// 标题
	private String title;

	// 摘要
	private String summary;

	// 内容
	private String content;

	// 状态
	private String status;

	// 发布平台
	private String sendPlatform;

	// 最后修改人
	private String updater;

	// 最后修改时间
	private String updateDatetime;

	// 备注
	private String reamrk;

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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setSendPlatform(String sendPlatform) {
		this.sendPlatform = sendPlatform;
	}

	public String getSendPlatform() {
		return sendPlatform;
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

	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}

	public String getReamrk() {
		return reamrk;
	}

}