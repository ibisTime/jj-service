/**
 * @Title ContractBOImpl.java 
 * @Package com.xnjr.pop.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月14日 下午3:38:26 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IContractBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IContractDAO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.Contract;
import com.xnjr.mall.domain.ContractTemplate;
import com.xnjr.mall.enums.EContractStatus;
import com.xnjr.mall.enums.EContractType;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月14日 下午3:38:26 
 * @history:
 */
@Component
public class ContractBOImpl extends PaginableBOImpl<Contract> implements
        IContractBO {
    @Autowired
    IContractDAO contractDAO;

    @Override
    public String generateBusiness(Business business, ContractTemplate template) {
        Contract contract = new Contract();
        String code = OrderNoGenerater.generateM("SYJ-YW-");
        contract.setCode(code);
        contract.setCompanyCode("CompanyCode");
        contract.setSubjectCode(business.getSubjectCode());
        String content = template.getContent();
        try {
            /**
             * contractNo 协议编号
             * signAddress 签约地点
             * partyA 甲方
             * jyAmount 经营资金
             * fcPrinciple 收益分层原则
             * APerson 甲方联系人
             * AMobile 甲方联系电话
             * AAddress 甲方联系地址
             */
            Map<String, String> argsMap = new HashMap<String, String>();
            argsMap.put("contractNo", code);
            argsMap.put("signAddress", "网上签约");
            // argsMap.put("PartyA", invest.getCode());
            // argsMap.put("jyAmount", "1000");
            // argsMap.put("APerson", "1000");
            // argsMap.put("AMobile", "1000");
            // argsMap.put("AAddress", "1000");
            // argsMap.put("createTime",
            // DateUtil.dateToStr(new Date(), DateUtil.DATA_TIME_PATTERN_6));
            content = replace(template.getContent(), argsMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        contract.setContent(content);
        contract.setType(EContractType.Business.getCode());
        contract.setCreateDatetime(new Date());
        contract.setRemark(EContractType.Business.getValue());
        contract.setStatus(EContractStatus.SX.getCode());
        contractDAO.insert(contract);
        return code;
    }

    private String replace(String template, Map<String, String> data)
            throws Exception {
        Matcher matcher = Pattern.compile("\\[(.+?)\\]").matcher(template);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (matcher.find()) {
            String name = matcher.group(1);// 键名
            String value = (String) data.get(name);
            if (StringUtils.isBlank(value)) {
                value = "";
            }
            matcher.appendReplacement(sb, value);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public Contract getContract(String code) {
        Contract data = null;
        if (StringUtils.isNotBlank(code)) {
            Contract condition = new Contract();
            condition.setCode(code);
            data = contractDAO.select(condition);
        }
        return data;
    }

    // private ContractTemplate getContractTemplate(EContractType father) {
    // ContractTemplate condition = new ContractTemplate();
    // condition.setType(father.getCode());
    // List<ContractTemplate> list = contractTemplateDAO.selectList(condition);
    // if (CollectionUtils.isNotEmpty(list)) {
    // return list.get(0);
    // } else {
    // throw new BizException("XN000000", father.getValue() + "合同模板不存在");
    // }
    // }

}
