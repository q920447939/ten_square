package cn.withmes.recruit.service.impl;


import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.recruit.entity.TbRecruit;
import cn.withmes.recruit.mapper.TbRecruitMapper;
import cn.withmes.recruit.service.TbRecruitService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 职位 服务实现类
 * @author leegoo
 * @date 2018-11-18
 */
@Service
public class TbRecruitServiceImpl extends BaseServiceImpl<TbRecruit> implements TbRecruitService {

	@Autowired
	private TbRecruitMapper mapper;

	@Override
	public BaseMapper<TbRecruit> getBaseMapper() {
		return mapper;
	}
	
}
