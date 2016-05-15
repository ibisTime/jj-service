package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKSubbranch;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午3:57:17 
 * @history:
 */
public interface IBKSubbranchAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String addBKSubbranch(BKSubbranch data);

    public int editBKSubbranch(BKSubbranch data);

    public int checkPass(String code, String updater, String remark);

    public int checkUnPass(String code, String updater, String remark);

    public int reEditBKSubbranch(String code, String updater, String remark);

    public Paginable<BKSubbranch> queryBKSubbranchPage(int start, int limit,
            BKSubbranch data);

    public List<BKSubbranch> queryBKSubbranchList(BKSubbranch data);

    public BKSubbranch getBKSubbranch(String code);

}
