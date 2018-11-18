package cn.withmes.recruit.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 职位
 * @author leegoo
 * @date 2018-11-18
 */
@Data
@Accessors(chain = true)
public class TbRecruitListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
	
    /**
     * 职位名称
     */
	private String jobname;
	
    /**
     * 薪资范围
     */
	private String salary;
	
    /**
     * 经验要求
     */
	private String conditions;
	
    /**
     * 学历要求
     */
	private String education;
	
    /**
     * 任职方式
     */
	private String type;
	
    /**
     * 办公地址
     */
	private String address;
	
    /**
     * 企业ID
     */
	private String eid;
	
    /**
     * 创建日期
     */
	private Date createtime;
	
    /**
     * 状态
     */
	private String state;
	
    /**
     * 网址
     */
	private String url;
	
    /**
     * 标签
     */
	private String label;
	
    /**
     * 职位描述
     */
	private String content1;
	
    /**
     * 职位要求
     */
	private String content2;
	


}
