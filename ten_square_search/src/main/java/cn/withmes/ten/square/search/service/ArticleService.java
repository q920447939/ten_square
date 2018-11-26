/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.search.service;

import cn.withmes.ten.square.search.entity.Article;

import java.util.List;

/**
 * ClassName: ArticleService
 * @Description:
 * @author leegoo
 * @date 2018年11月25日
 */

public interface ArticleService {
    void save (Article article);

    List<Article> findArticleOrCommentLike(String key, int page, int size);

}
