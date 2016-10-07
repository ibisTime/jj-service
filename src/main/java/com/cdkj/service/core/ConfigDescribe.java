package com.cdkj.service.core;

import java.util.List;

/**
 * Created by wulp on 2015/4/7.
 */
public class ConfigDescribe {
    private List<String> ipList;

    private List<String> codeList;

    public void printAllInfo() {

    }

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
