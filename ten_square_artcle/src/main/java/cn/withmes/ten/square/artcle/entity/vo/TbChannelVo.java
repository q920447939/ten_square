package cn.withmes.ten.square.artcle.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 频道
 * @author leegoo
 * @date 2018-11-21
 */
@Data
@Accessors(chain = true)

@TableName("tb_channel")
public class TbChannelVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
	private String id;

    /**
     * 频道名称
     */
	@TableField("name")
	private String name;

    /**
     * 状态
     */
	@TableField("state")
	private String state;



}
