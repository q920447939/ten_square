package cn.withmes.recruit.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.recruit.entity.TbEnterprise;
import cn.withmes.recruit.entity.vo.TbEnterpriseListVo;
import cn.withmes.recruit.entity.vo.TbEnterpriseVo;
import cn.withmes.recruit.service.TbEnterpriseService;
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
 *   @description : TbEnterprise 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-18
 */
@RestController
@RequestMapping("/tbEnterprise")
public class TbEnterpriseController extends BaseRestfulController {

@Autowired
public TbEnterpriseService tbEnterpriseService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/page")
public ResponseData<Page<TbEnterpriseListVo>> getTbEnterpriseList(TbEnterprise param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                                                                  @RequestParam(value = "length") Integer length,
                                                                  @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
/*  DatatablesJSON<TbEnterprise> resJson=new DatatablesJSON<>();
        try {
        Integer pageNo=getPageNo(start,length);
        Page<TbEnterprise> page=new Page<TbEnterprise>(pageNo,length);
    tbEnterpriseService.selectPage(page,new EntityWrapper<TbEnterprise>(param));
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
 * @description : 通过id获取TbEnterprise
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/getById")
public ResponseData<TbEnterpriseVo> getTbEnterpriseById(String id) {
        TbEnterprise dto = tbEnterpriseService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,TbEnterpriseVo.class));
        }

/**
 * @description : 通过id删除TbEnterprise
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@GetMapping(value = "/deleteById")
public ResponseData<Boolean> deleteTbEnterpriseById(String id) {
        /*JSONResult<TbEnterprise> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbEnterpriseService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 通过id更新TbEnterprise
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/update")
public ResponseData<Boolean> updateTbEnterpriseById(@RequestBody @Validated(value = UpdateValid.class) TbEnterprise param) {
/*  JSONResult<TbEnterprise> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbEnterpriseService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }

/**
 * @description : 添加TbEnterprise
 * ---------------------------------
 * @author : leegoo
 * @since : Create in 2018-11-18
 */
@PostMapping(value = "/add")
public ResponseData<Boolean> addTbEnterprise(@RequestBody @Validated(value = AddValid.class) TbEnterprise param) {
/*  JSONResult<TbEnterprise> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbEnterpriseService.insert(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
        }
        }