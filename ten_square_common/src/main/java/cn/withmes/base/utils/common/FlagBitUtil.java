/**
 *
 */
package cn.withmes.base.utils.common;

/**
 * 专门用于计算bit移位时的处理公式
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: xfxb-base-component
 * copyright:
 * createTime:
 * modifyTime:
 * modifyBy:
 */
public abstract class FlagBitUtil {

    /**
     * 把当前的optionBit加入到已有的flagBitValue中去
     * <p>
     * 在db中是(optionBit + flagBitValue) - bitand(optionBit , flagBitValue)
     *
     * @param optionBit
     * @param flagBitValue
     * @return
     */
    public static long addToFlagBitValue(long optionBit, long flagBitValue) {
        return optionBit | flagBitValue;
    }

    public static int addToFlagBitValue(int optionBit, int flagBitValue) {
        return optionBit | flagBitValue;
    }

    /**
     * 去除已有的flagBitValue中的当前optionBit，返回去除后的flagBitValue
     *
     * @param optionBit
     * @param flagBitValue
     * @return
     */
    public static long removeFromFlagBitValue(long optionBit, long flagBitValue) {
        return flagBitValue &= optionBit ^ Integer.MAX_VALUE;
    }

    public static int removeFromFlagBitValue(int optionBit, int flagBitValue) {
        return flagBitValue &= optionBit ^ Integer.MAX_VALUE;
    }

    /**
     * 判断flagBitValue中是否有optionBit
     *
     * @param optionFlagbit
     * @param flagBitValue
     * @return
     */
    public static boolean isExistInFlagBitValue(long optionFlagbit, long flagBitValue) {
        return (optionFlagbit & flagBitValue) > 0;
    }

    public static boolean isExistInFlagBitValue(int optionFlagbit, int flagBitValue) {
        return (optionFlagbit & flagBitValue) > 0;
    }

    /**
     * 获取n次幂
     *
     * @param value
     * @param base
     * @return
     */
    public static int power(long value, long base) {
        return (int) (Math.log(value) / Math.log(base));
    }
}
