package cn.withmes.ten.square.artcle.service.impl;

import cn.withmes.common.utils.common.CopyAttributesUtils;

import cn.withmes.common.service.BaseServiceImpl;
import  cn.withmes.common.dal.BaseMapper;
import cn.withmes.ten.square.artcle.entity.TbArticle;
import cn.withmes.ten.square.artcle.entity.vo.TbArticleListVo;
import cn.withmes.ten.square.artcle.mapper.TbArticleMapper;
import cn.withmes.ten.square.artcle.service.TbArticleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * @Description: 文章 服务实现类
 * @author leegoo
 * @date 2018-11-21
 */
@Service
public class TbArticleServiceImpl extends BaseServiceImpl<TbArticle> implements TbArticleService {

	@Autowired
	private TbArticleMapper mapper;

	@Override
	public BaseMapper<TbArticle> getBaseMapper() {
		return mapper;
	}

	@Override
	public   IPage<TbArticle> page (Page<TbArticle> page, TbArticleListVo vo) {
	TbArticle dto = CopyAttributesUtils.copyAtoB(vo, TbArticle.class);
		QueryWrapper wrapper = new QueryWrapper();
		
		IPage<TbArticle> pageList = mapper.selectPage(page, wrapper);
		return pageList;
	}
	
}
