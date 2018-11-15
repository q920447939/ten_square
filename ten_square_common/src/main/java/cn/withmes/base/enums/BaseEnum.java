package cn.withmes.base.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = BaseEnumSerializer.class)
public interface BaseEnum<E extends Enum<?>, T> {

	/**
	 * 获取编码
	 */
	T getCode();  
	
	/**
	 * 文字描述
	 */
    String getDesc();  
    
    /**
     * 枚举类型
     */
    String getName();
}
