/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月25日
 */
package cn.withmes.ten.square.search.controller;

import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.ten.square.search.entity.Article;
import cn.withmes.ten.square.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ArticleController
 *
 * @author leegoo
 * @Description:
 * @date 2018年11月25日
 */
@RestController
@RequestMapping("search")
@CrossOrigin
public class ArticleController extends BaseRestfulController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public ResponseData save (@RequestBody Article article) {
        articleService.save(article);
        return  successData();
    }
}
