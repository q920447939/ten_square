package cn.withmes.qa.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.qa.entity.TbUl;
import cn.withmes.qa.service.TbUlService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

    import org.springframework.stereotype.Controller;

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
 *   @description : TbUl 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-18
 */
@Controller
@RequestMapping("/tbUl")
public class TbUlController extends BaseRestfulController {

@Autowired
public TbUlService tbUlService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/page")
public ResponseData<IPage<TbUl>> getTbUlList(TbUl param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                                             @RequestParam(value = "length") Integer length,
                                             @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
/*  DatatablesJSON<TbUl> resJson=new DatatablesJSON<>();
        try {
        Integer pageNo=getPageNo(start,length);
        Page<TbUl> page=new Page<TbUl>(pageNo,length);
    tbUlService.selectPage(page,new EntityWrapper<TbUl>(param));
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
 * @description : 通过id获取TbUl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/getById")
public ResponseData<TbUl> getTbUlById(String id) {
/* JSONResult<TbUl> resJson = new JSONResult<>();
        try {
    TbUl param= tbUlService.selectById(id);
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
 * @description : 通过id删除TbUl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/deleteById")
public ResponseData<Boolean> deleteTbUlById(String id) {
        /*JSONResult<TbUl> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbUlService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 通过id更新TbUl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/update")
public ResponseData<Boolean> updateTbUlById(@RequestBody @Validated(value = UpdateValid.class) TbUl param) {
/*  JSONResult<TbUl> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbUlService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 添加TbUl
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/add")
public ResponseData<Boolean> addTbUl(@RequestBody @Validated(value = AddValid.class) TbUl param) {
/*  JSONResult<TbUl> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbUlService.insert(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }
        }