package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.dto.req.XNyw4021Req;
import com.xnjr.mall.dto.req.XNyw4023Req;
import com.xnjr.mall.spring.ServiceModule;

@ServiceModule
public interface IInvestTableAO {

    String addInvestTable(XNyw4021Req req);

    void dropInvestTable(String investTableCode);

    void editInvestTable(XNyw4023Req req);

    InvestTable getInvestTable(String investTableCode);

    List<InvestTable> queryInvestTableList(String investCode);

    List<InvestTable> querySubjectInvestTableList(String subjectCode);

}
