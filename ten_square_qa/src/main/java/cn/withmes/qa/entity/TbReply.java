package cn.withmes.qa.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 回答
 * @author leegoo
 * @date 2018-11-18
 */
@Data
@Accessors(chain = true)
public class TbReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	private String id;
	
    /**
     * 问题ID
     */
	private String problemid;
	
    /**
     * 回答内容
     */
	private String content;
	
    /**
     * 创建日期
     */
	private Date createtime;
	
    /**
     * 更新日期
     */
	private Date updatetime;
	
    /**
     * 回答人ID
     */
	private String userid;
	
    /**
     * 回答人昵称
     */
	private String nickname;
	


}
