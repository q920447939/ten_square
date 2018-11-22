package cn.withmes.ten.square.artcle.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 专栏
 * @author leegoo
 * @date 2018-11-21
 */
@Data
@Accessors(chain = true)

@TableName("tb_column")
public class TbColumnUpdateVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
	private String id;

    /**
     * 专栏名称
     */
	@TableField("name")
	private String name;

    /**
     * 专栏简介
     */
	@TableField("summary")
	private String summary;

    /**
     * 用户ID
     */
	@TableField("userid")
	private String userid;

    /**
     * 申请日期
     */
	@TableField("createtime")
	private Date createtime;

    /**
     * 审核日期
     */
	@TableField("checktime")
	private Date checktime;

    /**
     * 状态
     */
	@TableField("state")
	private String state;



}
