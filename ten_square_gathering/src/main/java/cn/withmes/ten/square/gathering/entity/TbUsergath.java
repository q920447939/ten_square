package cn.withmes.ten.square.gathering.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @Description: 用户关注活动
 * @author leegoo
 * @date 2018-11-23
 */
@Data
@Accessors(chain = true)

@TableName("tb_usergath")
public class TbUsergath implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("userid")
	private String userid;

    /**
     * 活动ID
     */
	@TableField("gathid")
	private String gathid;

    /**
     * 点击时间
     */
	@TableField("exetime")
	private Date exetime;



}
