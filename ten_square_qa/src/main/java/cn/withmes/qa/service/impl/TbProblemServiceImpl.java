package cn.withmes.qa.service.impl;

import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.qa.entity.TbProblem;
import cn.withmes.qa.mapper.TbProblemMapper;
import cn.withmes.qa.service.TbProblemService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 问题 服务实现类
 * @author leegoo
 * @date 2018-11-18
 */
@Service
public class TbProblemServiceImpl extends BaseServiceImpl<TbProblem> implements TbProblemService {

	@Autowired
	private TbProblemMapper mapper;

	@Override
	public BaseMapper<TbProblem> getBaseMapper() {
		return mapper;
	}

	@Override
	@Cacheable(value = "ten_square_qa.cn.withmes.qa.service.impl.TbProblemServiceImpl.newProblems", key = "#lableId")
	public List<TbProblem> newProblemsList(String lableId) {
		List<TbProblem> tbProblems = mapper.newProblems(lableId);
		return tbProblems;
	}
}
