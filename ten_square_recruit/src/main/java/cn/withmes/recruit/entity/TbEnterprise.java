package cn.withmes.recruit.entity;

import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 企业
 * @author leegoo
 * @date 2018-11-18
 */
@Data
@Accessors(chain = true)
public class TbEnterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
	
    /**
     * 企业名称
     */
	private String name;
	
    /**
     * 企业简介
     */
	private String summary;
	
    /**
     * 企业地址
     */
	private String address;
	
    /**
     * 标签列表
     */
	private String labels;
	
    /**
     * 坐标
     */
	private String coordinate;
	
    /**
     * 是否热门
     */
	private String ishot;
	
    /**
     * LOGO
     */
	private String logo;
	
    /**
     * 职位数
     */
	private Integer jobcount;
	
    /**
     * URL
     */
	private String url;
	


}
