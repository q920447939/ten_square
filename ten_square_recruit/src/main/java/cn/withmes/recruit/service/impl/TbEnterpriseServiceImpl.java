package cn.withmes.recruit.service.impl;

import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.recruit.entity.TbEnterprise;
import cn.withmes.recruit.mapper.TbEnterpriseMapper;
import cn.withmes.recruit.service.TbEnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 企业 服务实现类
 * @author leegoo
 * @date 2018-11-18
 */
@Service
public class TbEnterpriseServiceImpl extends BaseServiceImpl<TbEnterprise> implements TbEnterpriseService {

	@Autowired
	private TbEnterpriseMapper mapper;

	@Override
	public BaseMapper<TbEnterprise> getBaseMapper() {
		return mapper;
	}
	
}
