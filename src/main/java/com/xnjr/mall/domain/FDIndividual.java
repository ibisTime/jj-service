package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 资金方-个体户
 * @author: Gejin 
 * @since: 2016年4月18日 上午11:51:04 
 * @history:
 */
public class FDIndividual extends ABaseDO {

    private static final long serialVersionUID = 4363569950942669917L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 拥有的服务list
    private String serveList;

    // 拥有的报价list
    private String quoteList;

    // 等级
    private int level;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServeList() {
        return serveList;
    }

    public void setServeList(String serveList) {
        this.serveList = serveList;
    }

    public String getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(String quoteList) {
        this.quoteList = quoteList;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
