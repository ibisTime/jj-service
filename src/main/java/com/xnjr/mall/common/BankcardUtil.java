package com.xnjr.mall.common;
/**
 *银行卡校验
 * @author: zhanggl10620 
 * @since: 2014-9-23 上午10:34:22 
 * @history:
 */
public class BankcardUtil {
    
    
    /**
     * 校验银行卡卡号
     * @param cardId
     * @return 
     * @create: 2014-9-23 上午10:38:59 zhanggl10620
     * @history:
     */
    public static boolean CheckBankCard(String cardId){
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        return cardId.charAt(cardId.length() - 1) == bit;      
    }
    
    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     * @param nonCheckCodeCardId
     * @return 
     * @create: 2014-9-23 上午10:38:50 zhanggl10620
     * @history:
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            throw new IllegalArgumentException("Bank card code must be number!");
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;            
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }
}
