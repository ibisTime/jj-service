/**
 * @Title DemandConverter.java 
 * @Package com.cdkj.service.api.converter 
 * @Description 
 * @author xieyj  
 * @date 2016年10月7日 下午5:42:53 
 * @version V1.0   
 */
package com.cdkj.service.api.converter;

import com.cdkj.service.common.DateUtil;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.dto.req.CD612040Req;
import com.cdkj.service.dto.req.CD612041Req;
import com.cdkj.service.dto.req.CD612043Req;
import com.cdkj.service.dto.req.CD612050Req;

/** 
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:42:53 
 * @history:
 */
public class DemandConverter {

    public static Demand converter(CD612040Req req) {
        Demand result = new Demand();
        result.setName(req.getName());
        result.setQualityCode(req.getQualityCode());
        result.setExpCompany(req.getExpCompany());
        result.setUrgentLevel(req.getUrgentLevel());
        result.setDescription(req.getDescription());
        result.setPublisher(req.getPublisher());
        return result;
    }

    public static Demand converter(CD612041Req req) {
        Demand result = new Demand();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setQualityCode(req.getQualityCode());
        result.setExpCompany(req.getExpCompany());
        result.setUrgentLevel(req.getUrgentLevel());
        result.setDescription(req.getDescription());
        result.setPublisher(req.getPublisher());
        return result;
    }

    public static Demand converter(CD612043Req req) {
        Demand result = new Demand();
        result.setCode(req.getCode());
        result.setDealer(req.getDealer());
        result.setDealNote(req.getDealNote());
        return result;
    }

    public static Demand converter(CD612050Req req) {
        Demand result = new Demand();
        result.setMobile(req.getMobile());
        result.setPublisher(req.getPublisher());
        result.setStatus(req.getStatus());
        result.setQualityCode(req.getQualityCode());
        result.setType(req.getType());
        result.setUrgentLevel(req.getUrgentLevel());
        result.setPublishDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        result.setPublishDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        result.setDealer(req.getDealer());
        return result;
    }
}
