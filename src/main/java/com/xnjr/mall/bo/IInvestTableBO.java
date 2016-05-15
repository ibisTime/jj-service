package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.domain.InvestTable;

public interface IInvestTableBO {
    boolean isInvestTableExist(String investTableCode);

    String saveInvestTable(InvestTable data);

    void removeInvestTable(String investTableCode);

    void refreshInvestTable(InvestTable data);

    List<InvestTable> queryInvestTableList(String investCode);

    List<InvestTable> querySubjectInvestTableList(String subjectCode);

    void checkInvestAmount(String investCode, Long investAmount);

    InvestTable getInvestTable(String investTableCode);

    Long getInvestTotalAmount(String investCode);

}
