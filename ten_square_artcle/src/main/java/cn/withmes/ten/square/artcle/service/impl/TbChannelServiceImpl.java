package cn.withmes.ten.square.artcle.service.impl;

import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.utils.common.CopyAttributesUtils;

import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.ten.square.artcle.entity.TbChannel;
import cn.withmes.ten.square.artcle.entity.vo.TbChannelListVo;
import cn.withmes.ten.square.artcle.mapper.TbChannelMapper;
import cn.withmes.ten.square.artcle.service.TbChannelService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * @Description: 频道 服务实现类
 * @author leegoo
 * @date 2018-11-21
 */
@Service
public class TbChannelServiceImpl extends BaseServiceImpl<TbChannel> implements TbChannelService {

	@Autowired
	private TbChannelMapper mapper;

	@Override
	public BaseMapper<TbChannel> getBaseMapper() {
		return mapper;
	}

	@Override
	public   IPage<TbChannel> page (Page<TbChannel> page, TbChannelListVo vo) {
	TbChannel dto = CopyAttributesUtils.copyAtoB(vo, TbChannel.class);
		QueryWrapper wrapper = new QueryWrapper();
		
		IPage<TbChannel> pageList = mapper.selectPage(page, wrapper);
		return pageList;
	}
	
}
