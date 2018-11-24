/**
 * @Project: 吐槽
 * @Author: leegoo
 * @Date: 2018年11月24日
 */
package cn.withmes.ten.square.spit.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Spit
 *
 * @author leegoo
 * @Description: 吐槽
 * @date 2018年11月24日
 */
@Data
public class Spit implements Serializable {
    private String _id;
    private Date publishTime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentId;
}