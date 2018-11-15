package cn.withmes.base.service.impl;


import cn.withmes.base.dal.BaseMapper;
import cn.withmes.base.entity.TbLabel;
import cn.withmes.base.mapper.TbLabelMapper;
import cn.withmes.base.service.BaseServiceImpl;
import cn.withmes.base.service.TbLabelService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 标签 服务实现类
 * @author liming
 * @date 2018-11-15
 */
@Service
public class TbLabelServiceImpl extends BaseServiceImpl<TbLabel> implements TbLabelService {

	@Autowired
	private TbLabelMapper mapper;

	@Override
	public BaseMapper<TbLabel> getBaseMapper() {
		return mapper;
	}
	
}
