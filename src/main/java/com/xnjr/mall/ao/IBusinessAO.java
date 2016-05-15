package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.BusinessTable;
import com.xnjr.mall.spring.ServiceModule;

@ServiceModule
public interface IBusinessAO {
    String DEFAULT_ORDER_COLUMN = "code";

    // 上传业务资料
    public String uploadBusiness(String name, Long principal, Long profit,
            String hsbUrl, String hspzUrl, String fjUrl, String startDate,
            String endDate, String applyUser, String remark,
            String subjectCode, List<BusinessTable> list);

    // 重传业务资料
    public void reuploadBusiness(String code, String name, Long principal,
            Long profit, String hsbUrl, String hspzUrl, String fjUrl,
            String startDate, String endDate, String applyUser, String remark,
            List<BusinessTable> list);

    // 审核业务资料
    public void checkBusiness(String businessCode, String checkUser,
            String checkResult, String checkNote, String tradePwd);

    // 查询业务列表
    public Paginable<Business> queryBusinessPage(int start, int limit,
            Business condition);

    public List<Business> queryFrontBusinessList(String userId,
            String subjectCode);

    public Business getBusiness(String businessCode);

}
