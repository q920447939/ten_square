package cn.withmes.qa.service;


import cn.withmes.common.service.BaseService;
import cn.withmes.qa.entity.TbProblem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 问题 服务类
 * @author leegoo
 * @date 2018-11-18
 */
public interface TbProblemService extends BaseService<TbProblem> {
    List<TbProblem> newProblemsList( String lableId);
}
