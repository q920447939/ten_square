/** 
 *@Project: mcm-common 
 *@Author: liming
 *@Date: 2016年12月15日 
 * 
 */    
package cn.withmes.common.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: BeanFactoryHelper 
 * @author liming
 * @date 2016年12月15日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
@Configuration
public class BeanFactoryHelper implements BeanFactoryAware {
	
	//BEAN工厂
    private static BeanFactory beanFactory;
 
    @Override
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        BeanFactoryHelper.beanFactory = factory;
    }
    public static BeanFactory getBeanfactory() {
        return beanFactory;  
    }
 
}
