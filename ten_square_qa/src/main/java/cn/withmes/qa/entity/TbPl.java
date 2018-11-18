package cn.withmes.qa.entity;

import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 
 * @author leegoo
 * @date 2018-11-18
 */
@Data
@Accessors(chain = true)
public class TbPl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
	private String problemid;
	
    /**
     * 标签ID
     */
	private String labelid;
	


}
