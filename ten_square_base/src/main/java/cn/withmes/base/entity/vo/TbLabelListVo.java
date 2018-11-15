package cn.withmes.base.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class
TbLabelListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
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