package cn.withmes.base.utils.common;

/**
 * @version: v1.0
 * @author: Administrator
 * @Description: project: sysmanager
 * copyright: BLISSMALL TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2018/1/2 0002 下午 3:05
 * modifyTime:
 * modifyBy:
 */
public class NumberUtil {
    public static boolean effectId(Integer id) {
        if (id != null && id > 0) {
            return true;
        }
        return false;
    }
}
