package cn.withmes.qa.service.impl;


import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.qa.entity.TbUl;
import cn.withmes.qa.mapper.TbUlMapper;
import cn.withmes.qa.service.TbUlService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:  服务实现类
 * @author leegoo
 * @date 2018-11-18
 */
@Service
public class TbUlServiceImpl extends BaseServiceImpl<TbUl> implements TbUlService {

	@Autowired
	private TbUlMapper mapper;

	@Override
	public BaseMapper<TbUl> getBaseMapper() {
		return mapper;
	}
	
}
