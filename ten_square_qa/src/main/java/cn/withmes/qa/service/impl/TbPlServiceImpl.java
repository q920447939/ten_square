package cn.withmes.qa.service.impl;

import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.qa.entity.TbPl;
import cn.withmes.qa.mapper.TbPlMapper;
import cn.withmes.qa.service.TbPlService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:  服务实现类
 * @author leegoo
 * @date 2018-11-18
 */
@Service
public class TbPlServiceImpl extends BaseServiceImpl<TbPl> implements TbPlService {

	@Autowired
	private TbPlMapper mapper;

	@Override
	public BaseMapper<TbPl> getBaseMapper() {
		return mapper;
	}
	
}
