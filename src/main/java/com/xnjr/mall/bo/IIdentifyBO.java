package com.xnjr.mall.bo;

public interface IIdentifyBO {
    /**
     * 三方实名认证
     * @param userId
     * @param realName
     * @param idKind
     * @param idNo
     * @return 
     * @create: 2015年10月21日 下午6:12:32 myb858
     * @history:
     */
    public void doIdentify(String userId, String realName, String idKind,
            String idNo);
}
