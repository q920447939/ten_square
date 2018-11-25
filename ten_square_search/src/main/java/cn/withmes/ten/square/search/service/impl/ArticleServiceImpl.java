/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.search.service.impl;

import cn.withmes.common.utils.UuidUtils;
import cn.withmes.ten.square.search.dao.ArticleDao;
import cn.withmes.ten.square.search.entity.Article;
import cn.withmes.ten.square.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: ArticleServiceImpl
 * @Description:
 * @author leegoo
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
}
