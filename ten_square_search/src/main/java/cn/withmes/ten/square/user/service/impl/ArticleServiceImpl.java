/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.user.service.impl;

import cn.withmes.common.utils.UuidUtils;
import cn.withmes.ten.square.user.mapper.ArticleDao;
import cn.withmes.ten.square.user.entity.Article;
import cn.withmes.ten.square.user.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ArticleServiceImpl
 *
 * @author leegoo
 * @Description:
 * @date 2018年11月25日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public void save(Article article) {
        article.setId(UuidUtils.generate());
        articleDao.save(article);
    }

    @Override
    public List<Article> findArticleOrCommentLike(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return articleDao.findByTitleOrCommentLike(key,key, pageable);
    }
}
