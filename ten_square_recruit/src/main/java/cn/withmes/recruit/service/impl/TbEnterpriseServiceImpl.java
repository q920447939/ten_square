package cn.withmes.recruit.service.impl;

import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.common.utils.StringUtils;
import cn.withmes.recruit.entity.TbEnterprise;
import cn.withmes.recruit.mapper.TbEnterpriseMapper;
import cn.withmes.recruit.service.TbEnterpriseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

	@Override
	public IPage<TbEnterprise> page(Page<TbEnterprise> page, TbEnterprise param) {
		QueryWrapper wrapper = new QueryWrapper();
		if (!StringUtils.isNotEmpty(param.getIshot())) {
			wrapper.eq("ishot",param.getIshot());
		}
		IPage<TbEnterprise> userIPage = mapper.selectPage(page, wrapper);
		return userIPage;
	}
}
