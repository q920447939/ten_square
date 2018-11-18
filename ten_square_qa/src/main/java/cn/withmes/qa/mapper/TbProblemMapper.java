package cn.withmes.qa.mapper;


import cn.withmes.common.dal.BaseMapper;
import cn.withmes.qa.entity.TbProblem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 问题 Mapper 接口
 * @author leegoo
 * @date 2018-11-18
 */
public interface TbProblemMapper extends BaseMapper<TbProblem> {

    List<TbProblem> newProblems(@Param(value = "labelid") String lableId);
}
