package cn.withmes.base.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @Description: 标签
 * @author liming
 * @date 2018-11-15
 */
@TableName(value = "tb_label")
public class TbLabel implements Serializable {

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
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Long getFans() {
		return fans;
	}

	public void setFans(Long fans) {
		this.fans = fans;
	}

	@Override
	public String toString() {
		return "TbLabel{" +
			", id=" + id +
			", labelname=" + labelname +
			", state=" + state +
			", count=" + count +
			", recommend=" + recommend +
			", fans=" + fans +
			"}";
	}
}
