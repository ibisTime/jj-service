package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Integral;
import com.xnjr.mall.enums.EIntegralStatus;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 下午12:00:01 
 * @history:
 */
public interface IIntegralBO extends IPaginableBO<Integral> {

    public String saveIntegral(Integral data);

    public void isExistIntegral(String code);

    public List<Integral> queryIntegralList(Integral condition);

    public Integral getIntegral(String code);

    public int refreshIntegralStatus(String code, EIntegralStatus status,
            String updater, String remark);
}
