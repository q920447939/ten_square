package cn.withmes.qa.entity;

import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 
 * @author leegoo
 * @date 2018-11-18
 */
@Data
@Accessors(chain = true)
public class TbUl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private String uid;
	
    /**
     * 标签ID
     */
	private String lid;
	


}
