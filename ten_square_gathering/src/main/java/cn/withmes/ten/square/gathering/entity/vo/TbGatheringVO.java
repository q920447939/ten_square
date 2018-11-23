package cn.withmes.ten.square.gathering.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 活动
 * @author leegoo
 * @date 2018-11-23
 */
@Data
@Accessors(chain = true)

@TableName("tb_gathering")
public class TbGatheringVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId("id")
	private String id;

    /**
     * 活动名称
     */
	@TableField("name")
	private String name;

    /**
     * 大会简介
     */
	@TableField("summary")
	private String summary;

    /**
     * 详细说明
     */
	@TableField("detail")
	private String detail;

    /**
     * 主办方
     */
	@TableField("sponsor")
	private String sponsor;

    /**
     * 活动图片
     */
	@TableField("image")
	private String image;

    /**
     * 开始时间
     */
	@TableField("starttime")
	private Date starttime;

    /**
     * 截止时间
     */
	@TableField("endtime")
	private Date endtime;

    /**
     * 举办地点
     */
	@TableField("address")
	private String address;

    /**
     * 报名截止
     */
	@TableField("enrolltime")
	private Date enrolltime;

    /**
     * 是否可见
     */
	@TableField("state")
	private String state;

    /**
     * 城市
     */
	@TableField("city")
	private String city;



}
