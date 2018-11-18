package cn.withmes.qa.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.qa.entity.TbReply;
import cn.withmes.qa.service.TbReplyService;
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
 *   @description : TbReply 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-18
 */
@Controller
@RequestMapping("/tbReply")
public class TbReplyController extends BaseRestfulController {

@Autowired
public TbReplyService tbReplyService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/page")
public ResponseData<IPage<TbReply>> getTbReplyList(TbReply param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                                                   @RequestParam(value = "length") Integer length,
                                                   @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
/*  DatatablesJSON<TbReply> resJson=new DatatablesJSON<>();
        try {
        Integer pageNo=getPageNo(start,length);
        Page<TbReply> page=new Page<TbReply>(pageNo,length);
    tbReplyService.selectPage(page,new EntityWrapper<TbReply>(param));
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
 * @description : 通过id获取TbReply
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/getById")
public ResponseData<TbReply> getTbReplyById(String id) {
/* JSONResult<TbReply> resJson = new JSONResult<>();
        try {
    TbReply param= tbReplyService.selectById(id);
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
 * @description : 通过id删除TbReply
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/deleteById")
public ResponseData<Boolean> deleteTbReplyById(String id) {
        /*JSONResult<TbReply> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbReplyService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 通过id更新TbReply
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/update")
public ResponseData<Boolean> updateTbReplyById(@RequestBody @Validated(value = UpdateValid.class) TbReply param) {
/*  JSONResult<TbReply> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbReplyService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 添加TbReply
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/add")
public ResponseData<Boolean> addTbReply(@RequestBody @Validated(value = AddValid.class) TbReply param) {
/*  JSONResult<TbReply> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbReplyService.insert(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }
        }