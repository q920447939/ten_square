package cn.withmes.recruit.controller;


import cn.withmes.base.entity.TbLabel;
import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.recruit.entity.TbRecruit;
import cn.withmes.recruit.entity.vo.TbRecruitListVo;
import cn.withmes.recruit.entity.vo.TbRecruitVo;
import cn.withmes.recruit.service.TbRecruitService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author leegoo
 * @description : TbRecruit 控制器
 * ---------------------------------
 * @since 2018-11-18
 */
@RestController
@RequestMapping("/tbRecruit")
public class TbRecruitController extends BaseRestfulController {

    @Autowired
    public TbRecruitService tbRecruitService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-18
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbRecruit>> getTbRecruitList(@RequestBody TbRecruit param, @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                                                           @RequestParam(value = "length") Integer length,
                                                           @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}", draw, length, start);
        Page<TbRecruit> page = new Page<>(draw, length);
        IPage<TbRecruit> pageList = tbRecruitService.page(page, param);
        return successData(pageList);
    }

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-18
     */
    @PostMapping(value = "/pageByRecommend")
    public ResponseData<IPage<TbRecruit>> pageByRecommend(@RequestBody TbRecruit param, @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                                                           @RequestParam(value = "length") Integer length,
                                                           @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}", draw, length, start);
        Page<TbRecruit> page = new Page<>(draw, length);
        IPage<TbRecruit> pageList = tbRecruitService.pageByRecommend(page, param);
        return successData(pageList);
    }

    /**
     * @description : 通过id获取TbRecruit
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-18
     */
    @GetMapping(value = "/getById")
    public ResponseData<TbRecruitVo> getTbRecruitById(String id) {
/* JSONResult<TbRecruit> resJson = new JSONResult<>();
        try {
    TbRecruit param= tbRecruitService.selectById(id);
        resJson.setData(param);
        resJson.setSuccess(true);
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
    }

    /**
     * @description : 通过id删除TbRecruit
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-18
     */
    @GetMapping(value = "/deleteById")
    public ResponseData<Boolean> deleteTbRecruitById(String id) {
        /*JSONResult<TbRecruit> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbRecruitService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
    }

    /**
     * @description : 通过id更新TbRecruit
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-18
     */
    @PostMapping(value = "/update")
    public ResponseData<Boolean> updateTbRecruitById(@RequestBody @Validated(value = UpdateValid.class) TbRecruit param) {
/*  JSONResult<TbRecruit> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbRecruitService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
    }

    /**
     * @description : 添加TbRecruit
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-18
     */
    @PostMapping(value = "/add")
    public ResponseData<Boolean> addTbRecruit(@RequestBody @Validated(value = AddValid.class) TbRecruit param) {
/*  JSONResult<TbRecruit> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbRecruitService.insert(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
    }
}