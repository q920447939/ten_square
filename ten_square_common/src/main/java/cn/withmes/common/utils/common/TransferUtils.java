package cn.withmes.common.utils.common;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

/**
 * 对象转换工具类
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2017
 * createTime: 2017/5/9 12:56
 * modifyTime:
 * modifyBy:
 */
public class TransferUtils {

    public TransferUtils() {
    }

    public static <T, K> void transfer(T t, K k) {
        if (t != null && k != null) {
            BeanCopy.copyObjValue(t, k, false);
        }

    }

    public static <T, K> void transfer(T t, K k, boolean isCopyNull) {
        if (t != null && k != null) {
            BeanCopy.copyObjValue(t, k, isCopyNull);
        }

    }

    public static <T, K> void transferBean(T t, K k) {
        if (t != null && k != null) {
            BeanCopier bc = BeanCopier.create(t.getClass(), k.getClass(), false);
            bc.copy(t, k, (Converter) null);
        }

    }

}
