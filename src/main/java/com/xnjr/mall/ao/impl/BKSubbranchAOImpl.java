/**
 * @Title BKSubbranchAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:00:37 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IBKSubbranchAO;
import com.xnjr.mall.bo.IBKBankBO;
import com.xnjr.mall.bo.IBKSubbranchBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.domain.BKSubbranch;
import com.xnjr.mall.enums.ENormalStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:00:37 
 * @history:
 */
@Service
public class BKSubbranchAOImpl implements IBKSubbranchAO {

    @Autowired
    IBKSubbranchBO bkSubbranchBO;

    @Autowired
    IBKBankBO bkBankBO;

    @Override
    public String addBKSubbranch(BKSubbranch data) {
        BKBank bkBank = bkBankBO.getBKBank(data.getBankCode());
        if (bkBank == null) {
            throw new BizException("XNbk2000", "该银行不存在");
        }
        // 填充行名
        String bankName = bkBank.getName();
        data.setBankName(bankName);
        // 检查“银行名+支行名”唯一性
        bkSubbranchBO.checkBKSubbranchExist(bankName, data.getName());
        // 新增
        return bkSubbranchBO.saveBKSubbranch(data);
    }

    @Override
    public int editBKSubbranch(BKSubbranch data) {
        // 判断code 是否存在
        BKSubbranch subbranch = bkSubbranchBO.getBKSubbranch(data.getCode());
        if (subbranch == null) {
            throw new BizException("XNbk2000", "支行编号不存在");
        }
        if (ENormalStatus.PASS.getCode()
            .equalsIgnoreCase(subbranch.getStatus())) {
            throw new BizException("XNbk2000", "当前支行已审核通过，不允许重提操作");
        }
        // 设置银行名称
        BKBank bkBank = bkBankBO.getBKBank(data.getBankCode());
        if (bkBank == null) {
            throw new BizException("XNbk2000", "银行编号不存在");
        }
        // 填充行名
        String bankName = bkBank.getName();
        data.setBankName(bankName);
        // 检查“银行名+支行名”唯一性
        if (!subbranch.getBankName().equals(bankName)
                && !subbranch.getName().equals(data.getName())) {
            bkSubbranchBO.checkBKSubbranchExist(bankName, data.getName());
        }
        return bkSubbranchBO.refreshBKSubbranch(data);
    }

    @Override
    public List<BKSubbranch> queryBKSubbranchList(BKSubbranch data) {
        return bkSubbranchBO.queryBKSubbranchList(data);
    }

    @Override
    public BKSubbranch getBKSubbranch(String code) {
        return bkSubbranchBO.getBKSubbranch(code);
    }

    @Override
    public Paginable<BKSubbranch> queryBKSubbranchPage(int start, int limit,
            BKSubbranch data) {
        return bkSubbranchBO.getPaginable(start, limit, data);
    }

    @Override
    public int checkPass(String code, String updater, String remark) {
        checkSubbranch(code);
        BKSubbranch bkSubbranch = new BKSubbranch();
        bkSubbranch.setCode(code);
        bkSubbranch.setUpdater(updater);
        bkSubbranch.setRemark(remark);
        return bkSubbranchBO.refreshCheckPass(bkSubbranch);
    }

    @Override
    public int checkUnPass(String code, String updater, String remark) {
        checkSubbranch(code);
        BKSubbranch bkSubbranch = new BKSubbranch();
        bkSubbranch.setCode(code);
        bkSubbranch.setUpdater(updater);
        bkSubbranch.setRemark(remark);
        return bkSubbranchBO.refreshCheckUnPass(bkSubbranch);
    }

    @Override
    public int reEditBKSubbranch(String code, String updater, String remark) {
        BKSubbranch bkSubbranch = bkSubbranchBO.getBKSubbranch(code);
        if (bkSubbranch == null) {
            throw new BizException("XNbk2000", "该支行编号不存在");
        }
        if (!ENormalStatus.PASS.getCode().equalsIgnoreCase(
            bkSubbranch.getStatus())) {
            throw new BizException("XNbk2000", "该记录状态不是审核通过状态");
        }
        BKSubbranch subbranch = new BKSubbranch();
        subbranch.setCode(code);
        subbranch.setUpdater(updater);
        subbranch.setRemark(remark);
        return bkSubbranchBO.refreshReEditBKSubbranch(subbranch);
    }

    private void checkSubbranch(String code) {
        BKSubbranch bkSubbranch = bkSubbranchBO.getBKSubbranch(code);
        if (bkSubbranch == null) {
            throw new BizException("XNbk2000", "该编号不存在");
        }
        if (!ENormalStatus.NEW.getCode().equalsIgnoreCase(
            bkSubbranch.getStatus())) {
            throw new BizException("XNbk2000", "该记录状态不是待审核状态");
        }
    }
}
