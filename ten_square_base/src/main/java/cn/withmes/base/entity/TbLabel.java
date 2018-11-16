package cn.withmes.base.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 标签
 * </p>
 *
 * @author leegoo
 * @since 2018-11-15
 */
@Data
@Accessors(chain = true)
@TableName(value="tb_label")
public class TbLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    @TableField
    private String id;
    /**
     * 标签名称
     */
    private String labelname;
    /**
     * 状态
     */
    private String state;
    /**
     * 使用数量
     */
    private Long count;
    /**
     * 是否推荐
     */
    private String recommend;
    /**
     * 粉丝数
     */
    private Long fans;

}