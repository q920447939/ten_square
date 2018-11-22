package cn.withmes.ten.square.artcle.service.impl;

import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.ten.square.artcle.entity.TbColumn;
import cn.withmes.ten.square.artcle.entity.dto.TbColumnDTO;
import cn.withmes.ten.square.artcle.entity.vo.TbColumnListVo;
import cn.withmes.ten.square.artcle.mapper.TbColumnMapper;
import cn.withmes.ten.square.artcle.service.TbColumnService;
import cn.withmes.common.service.BaseServiceImpl;
import  cn.withmes.common.dal.BaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.withmes.common.utils.StringUtils;



/**
 * @Description: 专栏 服务实现类
 * @author leegoo
 * @date 2018-11-22
 */
@Service
public class TbColumnServiceImpl extends BaseServiceImpl<TbColumn> implements TbColumnService {

	@Autowired
	private TbColumnMapper mapper;

	@Override
	public BaseMapper<TbColumn> getBaseMapper() {
		return mapper;
	}

	@Override
	public   IPage<TbColumn> page (Page<TbColumnDTO> page, TbColumnListVo vo) {
		TbColumn dto = CopyAttributesUtils.copyAtoB(vo, TbColumn.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<TbColumn> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<TbColumn> pageList = mapper.selectPage(queryPage, wrapper);

		return pageList;
	}
	
}
