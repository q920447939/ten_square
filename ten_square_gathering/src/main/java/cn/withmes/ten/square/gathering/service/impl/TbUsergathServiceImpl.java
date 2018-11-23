package cn.withmes.ten.square.gathering.service.impl;

import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.ten.square.gathering.entity.TbUsergath;
import cn.withmes.ten.square.gathering.entity.dto.TbUsergathDTO;
import cn.withmes.ten.square.gathering.entity.vo.TbUsergathListVO;
import cn.withmes.ten.square.gathering.mapper.TbUsergathMapper;
import cn.withmes.ten.square.gathering.service.TbUsergathService;
import cn.withmes.common.service.BaseServiceImpl;
import  cn.withmes.common.dal.BaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.withmes.common.utils.StringUtils;



/**
 * @Description: 用户关注活动 服务实现类
 * @author leegoo
 * @date 2018-11-23
 */
@Service
public class TbUsergathServiceImpl extends BaseServiceImpl<TbUsergath> implements TbUsergathService {

	@Autowired
	private TbUsergathMapper mapper;

	@Override
	public BaseMapper<TbUsergath> getBaseMapper() {
		return mapper;
	}

	@Override
	public   IPage<TbUsergath> page (Page<TbUsergathDTO> page, TbUsergathListVO vo) {
		TbUsergath dto = CopyAttributesUtils.copyAtoB(vo, TbUsergath.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<TbUsergath> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<TbUsergath> pageList = mapper.selectPage(queryPage, wrapper);
		return pageList;
	}
	
}
