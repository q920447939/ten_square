package cn.withmes.qa.service.impl;

import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.qa.entity.TbReply;
import cn.withmes.qa.mapper.TbReplyMapper;
import cn.withmes.qa.service.TbReplyService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 回答 服务实现类
 * @author leegoo
 * @date 2018-11-18
 */
@Service
public class TbReplyServiceImpl extends BaseServiceImpl<TbReply> implements TbReplyService {

	@Autowired
	private TbReplyMapper mapper;

	@Override
	public BaseMapper<TbReply> getBaseMapper() {
		return mapper;
	}
	
}
