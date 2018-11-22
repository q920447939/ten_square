package cn.withmes.ten.square.artcle.service;


import cn.withmes.common.service.BaseService;
import cn.withmes.ten.square.artcle.entity.vo.TbArticleListVo;
import cn.withmes.ten.square.artcle.entity.TbArticle;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @Description: 文章 服务类
 * @author leegoo
 * @date 2018-11-21
 */
public interface TbArticleService extends BaseService<TbArticle> {
        IPage<TbArticle> page(Page<TbArticle> page, TbArticleListVo vo);
}
