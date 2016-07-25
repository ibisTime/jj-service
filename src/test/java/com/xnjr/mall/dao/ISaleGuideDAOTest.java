/**
 * @Title ISaleGuideDAOTest.java 
 * @Package com.xnjr.mall.base 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年7月25日 下午3:23:20 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import com.xnjr.mall.base.ADAOTest;
import com.xnjr.mall.domain.SaleGuide;

/** 
 * @author: haiqingzheng 
 * @since: 2016年7月25日 下午3:23:20 
 * @history:
 */
public class ISaleGuideDAOTest extends ADAOTest {
    @SpringBeanByType
    private ISaleGuideDAO saleGuideDAO;

    @Test
    public void insert() {
        SaleGuide data = new SaleGuide();
        data.setCode("SG00001");
        data.setModelCode("MM3432423432");
        data.setToLevel("1");
        data.setPrice(100L);
        data.setQuantity(100L);
        data.setUpdater("admin");
        data.setUpdateDatetime(new Date());
        data.setRemark("备注");
        int lineNum = saleGuideDAO.insert(data);
        logger.info("insert : {}", lineNum);
    }

    @Test
    public void update() {
        SaleGuide data = new SaleGuide();
        data.setCode("SG00001");
        data.setModelCode("MM3432423432update");
        data.setToLevel("1");
        data.setPrice(100L);
        data.setQuantity(100L);
        data.setUpdater("admin");
        data.setUpdateDatetime(new Date());
        data.setRemark("更新测试");
        int lineNum = saleGuideDAO.update(data);
        logger.info("update : {}", lineNum);
    }

    @Test
    public void selectList() {
        SaleGuide data = new SaleGuide();
        List<SaleGuide> dataList = saleGuideDAO.selectList(data);
        logger.info("selectList : {}", dataList);
    }
}
