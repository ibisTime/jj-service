package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IBKSubbranchBO;
import com.xnjr.mall.bo.ISYSLogBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IBKSubbranchDAO;
import com.xnjr.mall.domain.BKSubbranch;
import com.xnjr.mall.enums.ELogTable;
import com.xnjr.mall.enums.ENormalStatus;
import com.xnjr.mall.exception.BizException;

/**
 * 银行方-支行
 * @author: xieyj 
 * @since: 2016年4月15日 上午11:44:16 
 * @history:
 */
@Component
public class BKSubbranchBOImpl extends PaginableBOImpl<BKSubbranch> implements
        IBKSubbranchBO {
    @Autowired
    private ISYSLogBO sysLogBO;

    @Autowired
    private IBKSubbranchDAO bkSubbranchDAO;

    @Override
    public void checkBKSubbranchExist(String code) {
        BKSubbranch condition = new BKSubbranch();
        condition.setCode(code);
        if (bkSubbranchDAO.selectTotalCount(condition) < 1) {
            throw new BizException("XNbk2000", "支行不存在！");
        }

    }

    @Override
    public void checkBKSubbranchExist(String bankName, String subbranchName) {
        BKSubbranch condition = new BKSubbranch();
        condition.setBankName(bankName);
        condition.setName(subbranchName);
        if (bkSubbranchDAO.selectTotalCount(condition) >= 1) {
            throw new BizException("XNbk2000", "支行已经存在！");
        }
    }

    @Override
    public String saveBKSubbranch(BKSubbranch data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("BS");
            data.setCode(code);
            data.setStatus(ENormalStatus.NEW.getCode());
            Date now = new Date();
            data.setUpdateDatetime(now);
            sysLogBO.saveInsertLog(ELogTable.BKSubbranch.getCode(), code,
                data.getUpdater(), now);
            bkSubbranchDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshBKSubbranch(BKSubbranch data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.NEW.getCode());
            Date now = new Date();
            data.setUpdateDatetime(now);
            sysLogBO.saveUpdateLog(ELogTable.BKSubbranch.getCode(),
                data.getCode(), data.getUpdater(), now);
            count = bkSubbranchDAO.updateBKSubbranch(data);
        }
        return count;
    }

    @Override
    public int refreshCheckPass(BKSubbranch data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.PASS.getCode());
            Date now = new Date();
            data.setUpdateDatetime(now);
            sysLogBO.saveUpdateLog(ELogTable.BKSubbranch.getCode(),
                data.getCode(), "status", ENormalStatus.NEW.getCode(),
                ENormalStatus.PASS.getCode(), data.getUpdater(), now);
            count = bkSubbranchDAO.checkBKSubbranch(data);
        }
        return count;
    }

    @Override
    public int refreshCheckUnPass(BKSubbranch data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.UNPASS.getCode());
            Date now = new Date();
            data.setUpdateDatetime(now);
            sysLogBO.saveUpdateLog(ELogTable.BKSubbranch.getCode(),
                data.getCode(), "status", ENormalStatus.NEW.getCode(),
                ENormalStatus.UNPASS.getCode(), data.getUpdater(), now);
            count = bkSubbranchDAO.checkBKSubbranch(data);
        }
        return count;
    }

    @Override
    public int refreshReEditBKSubbranch(BKSubbranch data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.NEW.getCode());
            Date now = new Date();
            data.setUpdateDatetime(now);
            sysLogBO.saveUpdateLog(ELogTable.BKSubbranch.getCode(),
                data.getCode(), "status", ENormalStatus.PASS.getCode(),
                ENormalStatus.NEW.getCode(), data.getUpdater(), now);
            count = bkSubbranchDAO.checkBKSubbranch(data);
        }
        return count;
    }

    @Override
    public List<BKSubbranch> queryBKSubbranchList(BKSubbranch data) {
        return bkSubbranchDAO.selectList(data);
    }

    @Override
    public BKSubbranch getBKSubbranch(String code) {
        BKSubbranch bkSubbranch = null;
        if (StringUtils.isNotBlank(code)) {
            BKSubbranch condition = new BKSubbranch();
            condition.setCode(code);
            bkSubbranch = bkSubbranchDAO.select(condition);
        }
        return bkSubbranch;
    }
}
