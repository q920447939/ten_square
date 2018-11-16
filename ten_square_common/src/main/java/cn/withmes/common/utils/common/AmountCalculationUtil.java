package cn.withmes.common.utils.common;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

/**
 * @version: v1.0
 * @author: Administrator
 * @Description: project: sysmanager
 * copyright: BLISSMALL TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/5/17 0017 下午 2:57
 * modifyTime:
 * modifyBy:
 */
public class AmountCalculationUtil {
    /**
     * 金额按照比例分摊
     * totalValue*（amouont/totalAmount）
     *
     * @param totalValue  总金额
     * @param amouont
     * @param totalAmount
     * @return
     */
    public static int getPrice(int totalValue, int amouont, int totalAmount) {
        if(totalAmount==0)
            return 0;
        BigDecimal returnPrice = new BigDecimal(totalValue);
        return returnPrice.multiply(new BigDecimal(amouont)).
                divide(new BigDecimal(totalAmount), 0, ROUND_HALF_EVEN).intValue();
    }

    /**
     * 返回金额
     *
     * @param amount
     * @return
     */
    public static String buildProductAmount(int amount) {
        return new BigDecimal(amount).divide(new BigDecimal(100))
                .setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 返回金额
     *
     * @param amount
     * @return
     */
    public static double buildProductAmountDouble(int amount) {
        return new BigDecimal(amount).divide(new BigDecimal(100))
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
