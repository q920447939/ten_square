package cn.withmes.qa.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.qa.entity.TbProblem;
import cn.withmes.qa.service.TbProblemService;
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
 *   @description : TbProblem 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-18
 */
@Controller
@RequestMapping("/tbProblem")
public class TbProblemController extends BaseRestfulController {

@Autowired
public TbProblemService tbProblemService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/page")
public ResponseData<IPage<TbProblem>> getTbProblemList(TbProblem param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                                                       @RequestParam(value = "length") Integer length,
                                                       @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
/*  DatatablesJSON<TbProblem> resJson=new DatatablesJSON<>();
        try {
        Integer pageNo=getPageNo(start,length);
        Page<TbProblem> page=new Page<TbProblem>(pageNo,length);
    tbProblemService.selectPage(page,new EntityWrapper<TbProblem>(param));
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
 * @description : 通过id获取TbProblem
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/getById")
public ResponseData<TbProblem> getTbProblemById(String id) {
/* JSONResult<TbProblem> resJson = new JSONResult<>();
        try {
    TbProblem param= tbProblemService.selectById(id);
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
 * @description : 通过id删除TbProblem
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/deleteById")
public ResponseData<Boolean> deleteTbProblemById(String id) {
        /*JSONResult<TbProblem> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbProblemService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 通过id更新TbProblem
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/update")
public ResponseData<Boolean> updateTbProblemById(@RequestBody @Validated(value = UpdateValid.class) TbProblem param) {
/*  JSONResult<TbProblem> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbProblemService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 添加TbProblem
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/add")
public ResponseData<Boolean> addTbProblem(@RequestBody @Validated(value = AddValid.class) TbProblem param) {
/*  JSONResult<TbProblem> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbProblemService.insert(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }
        }