package cn.withmes.qa.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.qa.entity.TbPl;
import cn.withmes.qa.service.TbPlService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

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
 *   @description : TbPl 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-18
 */
@RestController
@RequestMapping("/tbPl")
public class TbPlController extends BaseRestfulController {

@Autowired
public TbPlService tbPlService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/page")
public ResponseData<IPage<TbPl>> getTbPlList(TbPl param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                                             @RequestParam(value = "length") Integer length,
                                             @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
/*  DatatablesJSON<TbPl> resJson=new DatatablesJSON<>();
        try {
        Integer pageNo=getPageNo(start,length);
        Page<TbPl> page=new Page<TbPl>(pageNo,length);
    tbPlService.selectPage(page,new EntityWrapper<TbPl>(param));
        resJson.setDraw(draw++);
        resJson.setRecordsTotal(page.getTotal());
        resJson.setRecordsFiltered(page.getTotal());
        resJson.setData(page.getRecords());
        resJson.setSuccess(true);
        }catch (Exception e){
        resJson.setSuccess(false);
        resJson.setError("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 通过id获取TbPl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/getById")
public ResponseData<TbPl> getTbPlById(String id) {
/* JSONResult<TbPl> resJson = new JSONResult<>();
        try {
    TbPl param= tbPlService.selectById(id);
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
 * @description : 通过id删除TbPl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/deleteById")
public ResponseData<Boolean> deleteTbPlById(String id) {
        /*JSONResult<TbPl> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbPlService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 通过id更新TbPl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/update")
public ResponseData<Boolean> updateTbPlById(@RequestBody @Validated(value = UpdateValid.class) TbPl param) {
/*  JSONResult<TbPl> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbPlService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 添加TbPl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/add")
public ResponseData<Boolean> addTbPl(@RequestBody @Validated(value = AddValid.class) TbPl param) {
/*  JSONResult<TbPl> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbPlService.insert(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }
        }