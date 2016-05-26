/**
 * @Title ModelAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 上午9:02:58 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IModelAO;
import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.IModelSpecsBO;
import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.domain.ModelSpecs;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EPutStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:02:58 
 * @history:
 */
@Service
public class ModelAOImpl implements IModelAO {

    @Autowired
    private IModelBO modelBO;

    @Autowired
    private IModelSpecsBO modelSpecsBO;

    @Autowired
    private IProductBO productBO;

    @Autowired
    private IBuyGuideBO buyGuideBO;

    /** 
     * @see com.xnjr.mall.ao.IModelAO#addModel(com.xnjr.mall.domain.Model)
     */
    @Override
    @Transactional
    public String addModel(Model data) {
        if (!productBO.isProductExist(data.getProductCode())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        String code = modelBO.saveModel(data);
        int k = 1;
        for (ModelSpecs modelSpecs : data.getModelSpecsList()) {
            modelSpecs.setModelCode(code);
            modelSpecs.setOrderNum(k++);
            modelSpecsBO.saveModelSpecs(modelSpecs);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.IModelAO#editModel(com.xnjr.mall.domain.Model)
     */
    @Override
    @Transactional
    public int editModel(Model data) {
        if (!productBO.isProductExist(data.getProductCode())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        int count = 0;
        if (data != null) {
            Model dbModel = modelBO.getModel(data.getCode());
            // 只有待审核和审核不通过的产品可进行修改
            if (EPutStatus.todoAPPROVE.getCode().equals(dbModel.getStatus())
                    || EPutStatus.APPROVE_NO.getCode().equals(
                        dbModel.getStatus())) {
                count = modelBO.refreshModel(data);
                // 型号规格表数据先删除，后增加
                modelSpecsBO.removeModelSpecsByModeCode(data.getCode());
                int k = 1;
                for (ModelSpecs modelSpecs : data.getModelSpecsList()) {
                    modelSpecs.setModelCode(data.getCode());
                    modelSpecs.setOrderNum(k++);
                    modelSpecsBO.saveModelSpecs(modelSpecs);
                }
            } else {
                throw new BizException("xn0000", "只有待审核和审核不通过的型号可进行修改");
            }
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.IModelAO#queryModelPage(int, int, com.xnjr.mall.domain.Model)
     */
    @Override
    public Paginable<Model> queryModelPage(int start, int limit, Model condition) {
        Paginable<Model> page = modelBO.getPaginable(start, limit, condition);
        if (page != null && page.getList() != null) {
            for (Model model : page.getList()) {
                ModelSpecs specsCondition = new ModelSpecs();
                specsCondition.setModelCode(model.getCode());
                List<ModelSpecs> list = modelSpecsBO
                    .queryModelSpecsList(specsCondition);
                model.setModelSpecsList(list);

                // 购买引导
                BuyGuide buyGuide = new BuyGuide();
                buyGuide.setModelCode(model.getCode());
                List<BuyGuide> buyGuideList = buyGuideBO
                    .queryBuyGuideList(buyGuide);
                model.setBuyGuideList(buyGuideList);
                if (!CollectionUtils.sizeIsEmpty(buyGuideList)) {
                    BuyGuide data = buyGuideList.get(0);
                    model.setOriginalPrice(data.getOriginalPrice());
                    model.setDiscountPrice(data.getDiscountPrice());
                }
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.IModelAO#queryModelList(com.xnjr.mall.domain.Model)
     */
    @Override
    public List<Model> queryModelList(Model condition) {
        List<Model> modelList = modelBO.queryModelList(condition);
        if (CollectionUtils.isNotEmpty(modelList)) {
            for (Model model : modelList) {
                ModelSpecs specsCondition = new ModelSpecs();
                specsCondition.setModelCode(model.getCode());
                List<ModelSpecs> list = modelSpecsBO
                    .queryModelSpecsList(specsCondition);
                model.setModelSpecsList(list);
                BuyGuide buyGuide = new BuyGuide();
                buyGuide.setModelCode(model.getCode());
                List<BuyGuide> buyGuideList = buyGuideBO
                    .queryBuyGuideList(buyGuide);
                model.setBuyGuideList(buyGuideList);
                if (!CollectionUtils.sizeIsEmpty(buyGuideList)) {
                    BuyGuide data = buyGuideList.get(0);
                    model.setOriginalPrice(data.getOriginalPrice());
                    model.setDiscountPrice(data.getDiscountPrice());
                }
            }
        }
        return modelList;
    }

    /** 
     * @see com.xnjr.mall.ao.IModelAO#getModel(java.lang.String)
     */
    @Override
    public Model getModel(String code) {
        Model model = modelBO.getModel(code);
        // 获取型号规格
        ModelSpecs specsCondition = new ModelSpecs();
        specsCondition.setModelCode(model.getCode());
        List<ModelSpecs> list = modelSpecsBO
            .queryModelSpecsList(specsCondition);
        model.setModelSpecsList(list);
        // 购买引导
        BuyGuide buyGuide = new BuyGuide();
        buyGuide.setModelCode(model.getCode());
        List<BuyGuide> buyGuideList = buyGuideBO.queryBuyGuideList(buyGuide);
        model.setBuyGuideList(buyGuideList);
        if (!CollectionUtils.sizeIsEmpty(buyGuideList)) {
            BuyGuide data = buyGuideList.get(0);
            model.setOriginalPrice(data.getOriginalPrice());
            model.setDiscountPrice(data.getDiscountPrice());
        }
        return model;
    }

    /** 
     * @see com.xnjr.mall.ao.IModelAO#checkModel(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int checkModel(String code, String checkUser, String checkResult,
            String checkNote) {
        int count = 0;
        Model model = modelBO.getModel(code);
        if (!EPutStatus.todoAPPROVE.getCode().equals(model.getStatus())) {
            throw new BizException("xn000000", "该型号不处于待审核状态");
        }
        if (EBoolean.YES.getCode().equals(checkResult)) {
            count = modelBO.approveModel(code, checkUser, checkNote);
        } else if (EBoolean.NO.getCode().equals(checkResult)) {
            count = modelBO.unApproveModel(code, checkUser, checkNote);
        } else {
            throw new BizException("xn000000", "审核结果传值有误");
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.IModelAO#putOnOffModel(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int putOnOffModel(String code, String checkUser, String checkResult,
            String checkNote) {
        int count = 0;
        Model model = modelBO.getModel(code);
        if (EBoolean.YES.getCode().equals(checkResult)) {
            if (!EPutStatus.APPROVE_YES.getCode().equals(model.getStatus())) {
                throw new BizException("xn000000", "该型号不处于审核通过状态，不能上架");
            }
            count = modelBO.putOn(code, checkUser, checkNote);
        } else if (EBoolean.NO.getCode().equals(checkResult)) {
            if (!EPutStatus.ONLINE.getCode().equals(model.getStatus())) {
                throw new BizException("xn000000", "该型号不处于上架状态，不能下架");
            }
            count = modelBO.putOff(code, checkUser, checkNote);
        } else {
            throw new BizException("xn000000", "审核结果传值有误");
        }
        return count;
    }

}
