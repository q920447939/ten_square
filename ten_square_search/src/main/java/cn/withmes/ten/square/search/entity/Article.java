/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * ClassName: Article
 * @Description:
 * @author leegoo
 * @date 2018年11月25日
 */
@Document(indexName = "ten_square_article",type = "article")
@Data
public class Article implements Serializable {

    @Id
    private  String id;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private  String title;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String comment;

    private  String state;
}
