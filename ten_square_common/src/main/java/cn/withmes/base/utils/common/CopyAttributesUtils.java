package cn.withmes.base.utils.common;

import cn.withmes.base.utils.converter.LocalDateTimeAndDateConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2017
 * createTime: 2017/4/6 16:45
 * modifyTime:
 * modifyBy:
 */
public class CopyAttributesUtils {
    /**
     * @param src
     * @param dest
     */
    @Deprecated
    public static void copyAttributes(Object src, Object dest) {
        Map<String, Object> srcMap = new HashMap<String, Object>();
        Field[] srcFields = src.getClass().getDeclaredFields();
        if (src.getClass().getSuperclass() != null) {
            Field[] srcSuperFields = src.getClass().getSuperclass().getDeclaredFields();
            srcFields = ArrayUtils.addAll(srcFields, srcSuperFields);
        }
        for (Field fd : srcFields) {
            try {
                fd.setAccessible(true);
                if (fd.get(src) != null) {
                    srcMap.put(fd.getName(), fd.get(src)); // 获取属性值
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Field[] destFields = dest.getClass().getDeclaredFields();
        if (destFields.getClass().getSuperclass() != null) {
            Field[] destSuperFields = dest.getClass().getSuperclass().getDeclaredFields();
            destFields = ArrayUtils.addAll(destFields, destSuperFields);

        }
        for (Field fd : destFields) {
            if (srcMap.get(fd.getName()) == null) {
                continue;
            }
            try {
                BeanUtils.setProperty(dest, fd.getName(), srcMap.get(fd.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static MapperFactory factory = null;

    public static MapperFactory getFactoryInstance(){
        synchronized (MapperFactory.class) {
            if(factory == null){
//                System.setProperty(OrikaSystemProperties.COMPILER_STRATEGY, EclipseJdtCompilerStrategy.class.getName());
                factory = new DefaultMapperFactory.Builder().build();
                factory.getConverterFactory().registerConverter(new LocalDateTimeAndDateConverter());
            }
        }
        return factory;
    }

    /**
     * @param sourceObject
     * @param destinationClass
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> D copyAtoB(S sourceObject, Class<D> destinationClass) {
        return getFactoryInstance().getMapperFacade().map(sourceObject, destinationClass);
    }

    /**
     * @param source
     * @param destinationClass
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> List<D> copyAlistToBlist(Iterable<S> source, Class<D> destinationClass) {
        return getFactoryInstance().getMapperFacade().mapAsList(source, destinationClass);
    }


}
