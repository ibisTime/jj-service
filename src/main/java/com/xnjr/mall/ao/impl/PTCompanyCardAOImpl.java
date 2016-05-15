package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.bo.IBKSubbranchBO;
import com.xnjr.mall.bo.IPTCompanyBO;
import com.xnjr.mall.bo.IPTCompanyCardBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKSubbranch;
import com.xnjr.mall.domain.PTCompany;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.enums.ENormalStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年3月5日 下午4:47:34 
 * @history:
 */
@Service
public class PTCompanyCardAOImpl implements IPTCompanyCardAO {
    @Autowired
    IPTCompanyCardBO ptCompanyCardBO;

    @Autowired
    IPTCompanyBO ptCompanyBO;

    @Autowired
    IBKSubbranchBO bkSubbranchBO;

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#addPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public String addPTCompanyCard(PTCompanyCard data) {
        checkPTCompanyCard(data.getCompanyCode(), data.getSubbranchCode());
        return ptCompanyCardBO.savePTCompanyCard(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#dropPTCompanyCard(java.lang.String)
     */
    @Override
    public int dropPTCompanyCard(String code) {
        PTCompanyCard result = ptCompanyCardBO.getPTCompanyCard(code);
        if (result == null) {
            throw new BizException("XNpt4000", "该公司账号不存在！");
        }
        return ptCompanyCardBO.removePTCompanyCard(code);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#editPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int editPTCompanyCard(PTCompanyCard data) {
        PTCompanyCard result = ptCompanyCardBO.getPTCompanyCard(data.getCode());
        if (result == null) {
            throw new BizException("XNpt4000", "该公司账号不存在！");
        }
        checkPTCompanyCard(data.getCompanyCode(), data.getSubbranchCode());
        return ptCompanyCardBO.refreshPTCompanyCard(data);
    }

    private void checkPTCompanyCard(String companyCode, String bankCode) {
        // 参数校验：公司编号，银行编号
        PTCompany company = ptCompanyBO.getPTCompany(companyCode);
        if (company == null) {
            throw new BizException("XNpt4000", "该公司不存在！");
        }
        BKSubbranch bank = bkSubbranchBO.getBKSubbranch(bankCode);
        if (bank == null) {
            throw new BizException("XNpt4000", "该开户支行不存在！");
        }
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#editJourDatePTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int editJourDatePTCompanyCard(PTCompanyCard data) {
        PTCompanyCard ptCompanyCard = ptCompanyCardBO.getPTCompanyCard(data
            .getCode());
        if (ptCompanyCard == null) {
            throw new BizException("XN000000", "公司账号不存在");
        }
        if (!ENormalStatus.PASS.getCode().equalsIgnoreCase(
            ptCompanyCard.getStatus())) {
            throw new BizException("XN000000", "该公司账号状态不是审核通过状态");
        }
        return ptCompanyCardBO.refreshJourDatePTCompanyCard(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#passPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int passPTCompanyCard(PTCompanyCard data) {
        return ptCompanyCardBO.refreshPassPTCompanyCard(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#unpassPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int unPassPTCompanyCard(PTCompanyCard data) {
        return ptCompanyCardBO.refreshUnPassPTCompanyCard(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#editIsAcceptPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int editIsAcceptPTCompanyCard(PTCompanyCard data) {
        return ptCompanyCardBO.refreshIsAcceptPTCompanyCard(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#queryPTCompanyCardList(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public List<PTCompanyCard> queryPTCompanyCardList(PTCompanyCard condition) {
        return ptCompanyCardBO.queryPTCompanyCardList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#queryPTCompanyCardPage(int, int, com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public Paginable<PTCompanyCard> queryPTCompanyCardPage(int start,
            int limit, PTCompanyCard condition) {
        return ptCompanyCardBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#getPTCompanyCard(java.lang.String)
     */
    @Override
    public PTCompanyCard getPTCompanyCard(String code) {
        return ptCompanyCardBO.getPTCompanyCard(code);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#queryDetailPTCompanyCardList(com.xnjr.moom.domain.DetailPTCompanyCard)
     */
    @Override
    public List<PTCompanyCard> queryDetailPTCompanyCardList(
            PTCompanyCard condition) {
        return ptCompanyCardBO.queryPTCompanyCardDetailList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyCardAO#queryDetailPTCompanyCardPage(int, int, com.xnjr.moom.domain.DetailPTCompanyCard)
     */
    @Override
    public Paginable<PTCompanyCard> queryDetailPTCompanyCardPage(int start,
            int limit, PTCompanyCard condition) {
        return ptCompanyCardBO.queryPTCompanyCardDetailPaginable(start, limit,
            condition);
    }
}
