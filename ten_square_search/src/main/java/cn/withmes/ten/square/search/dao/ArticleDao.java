/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.search.dao;

import cn.withmes.ten.square.search.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ClassName: ArticleDao
 * @Description:
 * @author leegoo
 * @date 2018年11月25日
 */
public interface ArticleDao extends ElasticsearchRepository<Article,String> {
}
