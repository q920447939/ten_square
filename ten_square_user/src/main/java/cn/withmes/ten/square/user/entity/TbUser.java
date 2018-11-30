package cn.withmes.ten.square.user.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @Description: 用户
 * @author leegoo
 * @date 2018-11-29
 */
@Data
@Accessors(chain = true)

@TableName("tb_user")
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value="id")
	private String id;

    /**
     * 手机号码
     */
	@TableField("mobile")
	private String mobile;

    /**
     * 密码
     */
	@TableField("password")
	private String password;

    /**
     * 昵称
     */
	@TableField("nickname")
	private String nickname;

    /**
     * 性别
     */
	@TableField("sex")
	private String sex;

    /**
     * 出生年月日
     */
	@TableField("birthday")
	private Date birthday;

    /**
     * 头像
     */
	@TableField("avatar")
	private String avatar;

    /**
     * E-Mail
     */
	@TableField("email")
	private String email;

    /**
     * 注册日期
     */
	@TableField("regdate")
	private Date regdate;

    /**
     * 修改日期
     */
	@TableField("updatedate")
	private Date updatedate;

    /**
     * 最后登陆日期
     */
	@TableField("lastdate")
	private Date lastdate;

    /**
     * 在线时长（分钟）
     */
	@TableField("online")
	private Long online;

    /**
     * 兴趣
     */
	@TableField("interest")
	private String interest;

    /**
     * 个性
     */
	@TableField("personality")
	private String personality;

    /**
     * 粉丝数
     */
	@TableField("fanscount")
	private Integer fanscount;

    /**
     * 关注数
     */
	@TableField("followcount")
	private Integer followcount;



}
