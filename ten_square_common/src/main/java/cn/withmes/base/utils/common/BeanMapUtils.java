package cn.withmes.base.utils.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2017
 * createTime: 2017/2/22 11:53
 * modifyTime:
 * modifyBy:
 */
public class BeanMapUtils {

    /**
     * Converts a JavaBean to a map.
     *
     * @param bean
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static Map<String, Object> beanToMapByPropertyDescriptor(Object bean) {
        if (bean == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beaninfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beaninfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String propertyName = propertyDescriptor.getName();
                if (!"class".equals(propertyName)) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if (readMethod == null) {
                        continue;
                    }
                    Object result = null;
                    result = readMethod.invoke(bean, new Object[0]);

                    if (result != null) {
                        map.put(propertyName, result);
                    } else {
                        map.put(propertyName, "");
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return map;
    }
}
