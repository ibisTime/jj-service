/**
 * @Title ADAOTest.java 
 * @Package com.ibis.pz.base 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 下午2:14:29 
 * @version V1.0   
 */
package com.cdkj.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

/** 
 * 此类只供数据层测试使用，用于数据回滚
 * @author: miyb 
 * @since: 2015-2-6 下午2:14:29 
 * @history:
 */
@Transactional(transactionManagerName = "transactionManager", value = TransactionMode.COMMIT)
public abstract class ADAOTest extends UnitilsJUnit4 {
    @SpringApplicationContext({ "classpath:spring/applicationContext.xml" })
    protected ApplicationContext applicationContext;

    protected static final Logger logger = LoggerFactory
        .getLogger(ADAOTest.class);

}
