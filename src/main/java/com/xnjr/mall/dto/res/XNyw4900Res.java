/**
 * @Title XNyw4900Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月30日 下午5:20:03 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月30日 下午5:20:03 
 * @history:
 */
public class XNyw4900Res {
    // 本金
    private Long totalPrincipal;

    // 累计投资
    private Long totalInvest;

    // 累计收益
    private Long totalProfit;

    public Long getTotalPrincipal() {
        return totalPrincipal;
    }

    public void setTotalPrincipal(Long totalPrincipal) {
        this.totalPrincipal = totalPrincipal;
    }

    public Long getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Long totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Long getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(Long totalInvest) {
        this.totalInvest = totalInvest;
    }
}
