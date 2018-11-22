package cn.withmes.ten.square.artcle.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.ten.square.artcle.entity.TbArticle;
import cn.withmes.ten.square.artcle.entity.vo.TbArticleAddVo;
import cn.withmes.ten.square.artcle.entity.vo.TbArticleListVo;
import cn.withmes.ten.square.artcle.entity.vo.TbArticleUpdateVo;
import cn.withmes.ten.square.artcle.entity.vo.TbArticleVo;
import cn.withmes.ten.square.artcle.service.TbArticleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import cn.withmes.common.web.BaseRestfulController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;


/**
 *code is far away from bug with the animal protecting
 *  ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *　　┃　　　┃神兽保佑
 *　　┃　　　┃代码无BUG！
 *　　┃　　　┗━━━┓
 *　　┃　　　　　　　┣┓
 *　　┃　　　　　　　┏┛
 *　　┗┓┓┏━┳┓┏┛
 *　　　┃┫┫　┃┫┫
 *　　　┗┻┛　┗┻┛
 *
 *   @description : TbArticleVo 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-21
 */
@RestController
@RequestMapping("/tb-article")
public class TbArticleController extends BaseRestfulController {

    @Autowired
    public TbArticleService tbArticleService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbArticleListVo>> getTbArticleList(
                @RequestBody TbArticleListVo param ,
                @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                @RequestParam(value = "length") Integer length,
                @RequestParam(value = "start") Integer start) {
            log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
            Page<TbArticle> page = new Page<>(draw, length);
            IPage<TbArticle> pageList = tbArticleService.page(page, param);
             IPage<TbArticleListVo> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
        return successData(iPage);
    }

    /**
     * @description : 通过id获取TbArticle
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<TbArticleVo> getTbArticleById(@PathVariable(name = "id") String id) {
        TbArticle dto = tbArticleService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,TbArticleVo.class));
    }

    /**
     * @description : 通过id删除TbArticle
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTbArticleById(@PathVariable(name = "id") String id) {
        log.info("deleteTbArticleById.id:{}",id);
        return successData( tbArticleService.delete(id));
    }

    /**
     * @description : 通过id更新TbArticle
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTbArticleById(@RequestBody  @Validated(value = UpdateValid.class) TbArticleUpdateVo param) {
        log.info("updateTbArticleById.param:{}",param);
        TbArticle e = CopyAttributesUtils.copyAtoB(param, TbArticle.class);
        return successData(tbArticleService.update(e));
    }

    /**
     * @description : 添加TbArticle
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @PostMapping(value = "/add")
    public ResponseData<Integer> addTbArticle(@RequestBody @Validated(value = AddValid.class) TbArticleAddVo param) {
        log.info("addTbArticle.param:{}",param);
        TbArticle e = CopyAttributesUtils.copyAtoB(param, TbArticle.class);
        return successData(tbArticleService.add(e));
    }
}