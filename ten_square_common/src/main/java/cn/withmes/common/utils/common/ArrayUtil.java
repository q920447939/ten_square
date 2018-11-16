package cn.withmes.common.utils.common;

import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2017
 * createTime: 2017/3/7 12:07
 * modifyTime:
 * modifyBy:
 */
public class ArrayUtil {

    /**
     * 可以用这个代替以下函数
     * invoiceTypeList.stream().mapToInt(i->i).toArray();
     *
     * @param list
     * @return
     */
    public static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }

}
