/**
 * @Title InvoiceAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午9:37:32 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IInvoiceAO;
import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.bo.IAddressBO;
import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.IInvoiceBO;
import com.xnjr.mall.bo.IInvoiceModelBO;
import com.xnjr.mall.bo.ILogisticsBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Address;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.domain.InvoiceModel;
import com.xnjr.mall.dto.res.XN802011Res;
import com.xnjr.mall.dto.res.XN805901Res;
import com.xnjr.mall.enums.EDirection;
import com.xnjr.mall.enums.EInvoiceStatus;
import com.xnjr.mall.enums.ESysAccount;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:37:32 
 * @history:
 */
@Service
public class InvoiceAOImpl implements IInvoiceAO {

    @Autowired
    private IInvoiceBO invoiceBO;

    @Autowired
    private IInvoiceModelBO invoiceModelBO;

    @Autowired
    private ICartBO cartBO;

    @Autowired
    private IAddressBO addressBO;

    @Autowired
    private IBuyGuideBO buyGuideBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private IAccountBO accountBO;

    /**
     * @see com.xnjr.mall.ao.IInvoiceAO#commitInvoice(java.lang.String, java.lang.Integer, java.lang.Long, com.xnjr.mall.domain.Invoice)
     */
    @Override
    @Transactional
    public String commitInvoice(String modelCode, Integer quantity,
            Long salePrice, Invoice data) {
        String code = invoiceBO.saveInvoice(data);
        invoiceModelBO.saveInvoiceModel(code, modelCode, quantity, salePrice);
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.IInvoiceAO#commitInvoice(com.xnjr.mall.domain.Invoice)
     */
    @Override
    @Transactional
    public String commitInvoice(List<String> cartCodeList, Invoice data) {
        // 获取购物车中的记录，形成订单型号关联表
        if (CollectionUtils.isEmpty(cartCodeList)) {
            throw new BizException("xn0000", "请选择购物车中的货物");
        }

        String code = invoiceBO.saveInvoice(data);
        // 获取用户信息
        String userId = data.getApplyUser();
        XN805901Res user = userBO.getRemoteUser(userId, userId);
        for (String cartCode : cartCodeList) {
            Cart cart = cartBO.getCart(cartCode);
            Long salePrice = buyGuideBO.getBuyGuidePrice(cart.getModelCode(),
                user.getLevel());
            invoiceModelBO.saveInvoiceModel(code, cart.getModelCode(),
                cart.getQuantity(), salePrice);
        }
        // 删除购物车选中记录
        for (String cartCode : cartCodeList) {
            cartBO.removeCart(cartCode);
        }
        return code;
    }

    @Override
    @Transactional
    public void toPayInvoice(String code, String tradePwd) {
        Invoice invoice = invoiceBO.getInvoice(code);
        if (!EInvoiceStatus.TO_PAY.getCode().equals(invoice.getStatus())) {
            throw new BizException("xn000000", "订单不处于待支付状态");
        }
        // 当前用户充值，划出；系统账户划入
        XN802011Res res = accountBO.getAccountByUserId(invoice.getApplyUser());
        // accountBO.doChargeOfflineWithoutApp(res.getAccountNumber(),
        // invoice.getTotalAmount(), "alipay", "6228584324242", "无", "admin",
        // "线上支付模拟", code);
        accountBO.doTransferOss(res.getAccountNumber(),
            EDirection.MINUS.getCode(), invoice.getTotalAmount(), 0L, "购买商品");
        accountBO.doTransferOss(ESysAccount.SYS_ACCOUNT.getCode(),
            EDirection.PLUS.getCode(), invoice.getTotalAmount(), 0L, "卖出商品");
        invoiceBO.refreshInvoiceStatus(code, EInvoiceStatus.PAY_YES.getCode());
        invoiceBO.refreshInvoicePayAmount(code, invoice.getTotalAmount());
    }

    /** 
     * @see com.xnjr.mall.ao.IInvoiceAO#cancelInvoice(java.lang.String, java.lang.String)
     */
    @Override
    public int cancelInvoice(String code, String userId, String approveNote) {
        Invoice data = invoiceBO.getInvoice(code);
        if (!userId.equals(data.getApplyUser())) {
            throw new BizException("xn0000", "订单申请人和取消操作用户不符");
        }
        if (!EInvoiceStatus.TO_PAY.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "订单状态不是待支付状态");
        }
        return invoiceBO.cancelInvoice(code, approveNote);
    }

    /**
     * @see com.xnjr.mall.ao.IInvoiceAO#cancelInvoice(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int cancelInvoiceOss(String code, String approveUser,
            String approveNote) {
        Invoice data = invoiceBO.getInvoice(code);
        if (!EInvoiceStatus.TO_PAY.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "订单状态不是待支付状态");
        }
        if (StringUtils.isBlank(approveNote)) {
            approveNote = "管理端取消订单";
        }
        return invoiceBO.cancelInvoice(code, approveUser, approveNote,
            EInvoiceStatus.FINISH.getCode());
    }

    /** 
     * @see com.xnjr.mall.ao.IInvoiceAO#payInvoice(com.xnjr.mall.domain.Invoice)
     */
    @Override
    @Transactional
    public void payInvoice(String code, Long amount, String fromType,
            String fromCode, String pdf, String toCardNo, String approveUser,
            String approveNote) {
        Long payAmount = 0L;
        Invoice invoice = invoiceBO.getInvoice(code);
        // 更新订单
        if (EInvoiceStatus.TO_PAY.getCode().equals(invoice.getStatus())) {
            if (amount == null || amount.longValue() == 0) {
                throw new BizException("xn0000", "首款金额不能为空");
            }
            invoiceBO.refreshInvoiceStatus(code,
                EInvoiceStatus.PAY_YES.getCode());
            payAmount = amount;
        } else {
            amount = invoice.getTotalAmount() - invoice.getPayAmount();
            if (EInvoiceStatus.RECEIVE.getCode().equals(invoice.getStatus())) {
                invoiceBO.refreshInvoiceStatus(code,
                    EInvoiceStatus.FINISH.getCode());
            }
            payAmount = invoice.getTotalAmount();
        }
        // 更新支付金额
        invoiceBO.refreshInvoicePayAmount(code, payAmount);
        // 当前用户充值，划出；系统账户划入
        XN802011Res res = accountBO.getAccountByUserId(invoice.getApplyUser());
        accountBO.doChargeOfflineWithoutApp(res.getAccountNumber(), amount,
            fromType, fromCode, pdf, approveUser, approveNote, code);
        accountBO
            .doTransferOss(res.getAccountNumber(), EDirection.MINUS.getCode(),
                amount, 0L, EDirection.MINUS.getValue());
        accountBO.doTransferOss(ESysAccount.SYS_ACCOUNT.getCode(),
            EDirection.PLUS.getCode(), amount, 0L, EDirection.PLUS.getValue());
    }

    /** 
     * @see com.xnjr.mall.ao.IInvoiceAO#queryInvoicePage(int, int, com.xnjr.mall.domain.Invoice)
     */
    @Override
    public Paginable<Invoice> queryInvoicePage(int start, int limit,
            Invoice condition) {
        Paginable<Invoice> page = invoiceBO.getPaginable(start, limit,
            condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (Invoice invoice : page.getList()) {
                InvoiceModel imCondition = new InvoiceModel();
                imCondition.setInvoiceCode(invoice.getCode());
                List<InvoiceModel> invoiceModelList = invoiceModelBO
                    .queryInvoiceModelList(imCondition);
                invoice.setInvoiceModelList(invoiceModelList);
                Long totalAmount = 0L;
                for (InvoiceModel invoiceModel : invoiceModelList) {
                    totalAmount += invoiceModel.getQuantity()
                            * invoiceModel.getSalePrice();
                }
                invoice.setTotalAmount(totalAmount);
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.IInvoiceAO#queryInvoiceList(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public List<Invoice> queryInvoiceList(Invoice condition) {
        List<Invoice> list = invoiceBO.queryInvoiceList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Invoice invoice : list) {
                InvoiceModel imCondition = new InvoiceModel();
                imCondition.setInvoiceCode(invoice.getCode());
                List<InvoiceModel> invoiceModelList = invoiceModelBO
                    .queryInvoiceModelList(imCondition);
                invoice.setInvoiceModelList(invoiceModelList);
                Long totalAmount = 0L;
                for (InvoiceModel invoiceModel : invoiceModelList) {
                    totalAmount += invoiceModel.getQuantity()
                            * invoiceModel.getSalePrice();
                }
                invoice.setTotalAmount(totalAmount);
            }
        }
        return list;
    }

    /** 
     * @see com.xnjr.mall.ao.IInvoiceAO#getInvoice(java.lang.String)
     */
    @Override
    public Invoice getInvoice(String code) {
        Invoice invoice = invoiceBO.getInvoice(code);
        // 收货地址信息
        Address address = addressBO.getAddress(invoice.getAddressCode());
        invoice.setAddress(address);
        // 附带物流信息
        if (EInvoiceStatus.SEND.getCode().equalsIgnoreCase(invoice.getStatus())
                || EInvoiceStatus.RECEIVE.getCode().equalsIgnoreCase(
                    invoice.getStatus())
                || EInvoiceStatus.FINISH.getCode().equalsIgnoreCase(
                    invoice.getStatus())) {
            invoice.setLogistics(logisticsBO.getLogisticsByInvoiceCode(code));
        }
        return invoice;
    }
}
