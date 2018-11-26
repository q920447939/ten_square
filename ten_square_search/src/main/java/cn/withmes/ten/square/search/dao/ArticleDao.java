/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.search.dao;

import cn.withmes.ten.square.search.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * ClassName: ArticleDao
 *
 * @author leegoo
 * @Description:
 * @date 2018年11月25日
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {
    List<Article> findByTitleOrCommentLike(String title,String comment, Pageable pageable);
}
