package cn.withmes.ten.square.gathering.service.impl;

import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.ten.square.gathering.entity.TbGathering;
import cn.withmes.ten.square.gathering.entity.dto.TbGatheringDTO;
import cn.withmes.ten.square.gathering.entity.vo.TbGatheringListVO;
import cn.withmes.ten.square.gathering.mapper.TbGatheringMapper;
import cn.withmes.ten.square.gathering.service.TbGatheringService;
import cn.withmes.common.service.BaseServiceImpl;
import  cn.withmes.common.dal.BaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * @Description: 活动 服务实现类
 * @author leegoo
 * @date 2018-11-23
 */
@Service
public class TbGatheringServiceImpl extends BaseServiceImpl<TbGathering> implements TbGatheringService {

	@Autowired
	private TbGatheringMapper mapper;

	@Override
	public BaseMapper<TbGathering> getBaseMapper() {
		return mapper;
	}

	@Override
	public   IPage<TbGathering> page (Page<TbGatheringDTO> page, TbGatheringListVO vo) {
		TbGathering dto = CopyAttributesUtils.copyAtoB(vo, TbGathering.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<TbGathering> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<TbGathering> pageList = mapper.selectPage(queryPage, wrapper);
		return pageList;
	}
	
}
