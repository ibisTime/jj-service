package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ISmsOutAO;
import com.xnjr.mall.bo.ISmsOutBO;

@Service
public class SmsOutAOImpl implements ISmsOutAO {
    @Autowired
    ISmsOutBO smsOutBO;

    @Override
    @Transactional
    public void sendCaptcha(String mobile, String bizType) {
        smsOutBO.sendCaptcha(mobile, bizType);
    }
}
