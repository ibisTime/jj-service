package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IPTCompanyCardBO;
import com.xnjr.mall.bo.base.Page;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IPTCompanyCardDAO;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.ENormalStatus;

/** 
 * @author: xieyj 
 * @since: 2016年3月5日 下午4:32:03 
 * @history:
 */
@Component
public class PTCompanyCardBOImpl extends PaginableBOImpl<PTCompanyCard>
        implements IPTCompanyCardBO {

    @Autowired
    private IPTCompanyCardDAO ptCompanyCardDAO;

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#savePTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public String savePTCompanyCard(PTCompanyCard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("PC");
            data.setCode(code);
            data.setStatus(ENormalStatus.NEW.getCode());
            data.setIsAccept(EBoolean.NO.getCode());
            data.setUpdateDatetime(new Date());
            ptCompanyCardDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#removePTCompanyCard(java.lang.String)
     */
    @Override
    public int removePTCompanyCard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            PTCompanyCard data = new PTCompanyCard();
            data.setCode(code);
            count = ptCompanyCardDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#refreshPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int refreshPTCompanyCard(PTCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.NEW.getCode());
            data.setUpdateDatetime(new Date());
            count = ptCompanyCardDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#refreshJourDatePTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int refreshJourDatePTCompanyCard(PTCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = ptCompanyCardDAO.updateJourDatePTCompanyCard(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#refreshPassPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int refreshPassPTCompanyCard(PTCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.PASS.getCode());
            data.setUpdateDatetime(new Date());
            count = ptCompanyCardDAO.updatePassPTCompanyCard(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#refreshNoPassePTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int refreshUnPassPTCompanyCard(PTCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ENormalStatus.UNPASS.getCode());
            data.setUpdateDatetime(new Date());
            count = ptCompanyCardDAO.updateUnPassPTCompanyCard(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#refreshIsAcceptPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int refreshIsAcceptPTCompanyCard(PTCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = ptCompanyCardDAO.updateIsAcceptPTCompanyCard(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#queryPTCompanyCardList(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public List<PTCompanyCard> queryPTCompanyCardList(PTCompanyCard condition) {
        return ptCompanyCardDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#getPTCompanyCard(java.lang.String)
     */
    @Override
    public PTCompanyCard getPTCompanyCard(String code) {
        PTCompanyCard data = null;
        if (StringUtils.isNotBlank(code)) {
            PTCompanyCard condition = new PTCompanyCard();
            condition.setCode(code);
            data = ptCompanyCardDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#queryPTCompanyCardDetailPaginable(int, int, com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public Paginable<PTCompanyCard> queryPTCompanyCardDetailPaginable(
            int start, int pageSize, PTCompanyCard condition) {
        long totalCount = ptCompanyCardDAO.selectDetailTotalCount(condition);
        Paginable<PTCompanyCard> page = new Page<PTCompanyCard>(start,
            pageSize, totalCount);
        List<PTCompanyCard> dataList = ptCompanyCardDAO.selectDetailList(
            condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyCardBO#queryPTCompanyCardDetailList(int, int, com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public List<PTCompanyCard> queryPTCompanyCardDetailList(
            PTCompanyCard condition) {
        return ptCompanyCardDAO.selectDetailList(condition);
    }
}
