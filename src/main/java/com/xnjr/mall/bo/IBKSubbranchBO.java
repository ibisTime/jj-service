package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.BKSubbranch;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午3:16:49 
 * @history:
 */
public interface IBKSubbranchBO extends IPaginableBO<BKSubbranch> {
    public void checkBKSubbranchExist(String code);

    public void checkBKSubbranchExist(String bankName, String subbranchName);

    public String saveBKSubbranch(BKSubbranch data);

    public int refreshBKSubbranch(BKSubbranch data);

    public int refreshCheckPass(BKSubbranch data);

    public int refreshCheckUnPass(BKSubbranch data);

    public int refreshReEditBKSubbranch(BKSubbranch data);

    public BKSubbranch getBKSubbranch(String code);

    public List<BKSubbranch> queryBKSubbranchList(BKSubbranch data);
}
