package com.cdkj.service.core;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.cdkj.service.exception.BizException;

public class CalculationUtil {

    public static String mult(String number) {
        DecimalFormat df = new DecimalFormat(".00");
        df.setRoundingMode(RoundingMode.FLOOR);
        Double money;
        try {
            String m = df.format(Double.parseDouble(number));
            money = Double.parseDouble(m) * 1000;
        } catch (Exception e) {
            throw new BizException("zc000001", "金额必须是数字类型");
        }
        return String.valueOf(money.longValue());
    }

    public static String divi(Long money) {
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(money / 1000.0);
    }
}
