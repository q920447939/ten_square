package cn.withmes.ten.square.artcle.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 文章
 * @author leegoo
 * @date 2018-11-21
 */
@Data
@Accessors(chain = true)

@TableName("tb_article")
public class TbArticleUpdateVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
	private String id;

    /**
     * 专栏ID
     */
	@TableField("columnid")
	private String columnid;

    /**
     * 用户ID
     */
	@TableField("userid")
	private String userid;

    /**
     * 标题
     */
	@TableField("title")
	private String title;

    /**
     * 文章正文
     */
	@TableField("content")
	private String content;

    /**
     * 文章封面
     */
	@TableField("image")
	private String image;

    /**
     * 发表日期
     */
	@TableField("createtime")
	private Date createtime;

    /**
     * 修改日期
     */
	@TableField("updatetime")
	private Date updatetime;

    /**
     * 是否公开
     */
	@TableField("ispublic")
	private String ispublic;

    /**
     * 是否置顶
     */
	@TableField("istop")
	private String istop;

    /**
     * 浏览量
     */
	@TableField("visits")
	private Integer visits;

    /**
     * 点赞数
     */
	@TableField("thumbup")
	private Integer thumbup;

    /**
     * 评论数
     */
	@TableField("comment")
	private Integer comment;

    /**
     * 审核状态
     */
	@TableField("state")
	private String state;

    /**
     * 所属频道
     */
	@TableField("channelid")
	private String channelid;

    /**
     * URL
     */
	@TableField("url")
	private String url;

    /**
     * 类型
     */
	@TableField("type")
	private String type;



}
