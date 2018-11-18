package cn.withmes.qa.entity;

import java.util.Date;
import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 问题
 * @author leegoo
 * @date 2018-11-18
 */
@Data
@Accessors(chain = true)
public class TbProblem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
	
    /**
     * 标题
     */
	private String title;
	
    /**
     * 内容
     */
	private String content;
	
    /**
     * 创建日期
     */
	private Date createtime;
	
    /**
     * 修改日期
     */
	private Date updatetime;
	
    /**
     * 用户ID
     */
	private String userid;
	
    /**
     * 昵称
     */
	private String nickname;
	
    /**
     * 浏览量
     */
	private Long visits;
	
    /**
     * 点赞数
     */
	private Long thumbup;
	
    /**
     * 回复数
     */
	private Long reply;
	
    /**
     * 是否解决
     */
	private String solve;
	
    /**
     * 回复人昵称
     */
	private String replyname;
	
    /**
     * 回复日期
     */
	private Date replytime;
	


}
