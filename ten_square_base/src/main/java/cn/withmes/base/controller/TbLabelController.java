package cn.withmes.base.controller;


import cn.withmes.base.entity.TbLabel;
import cn.withmes.base.entity.vo.TbLabelListVo;
import cn.withmes.common.enums.ResultCode;
import cn.withmes.base.mapper.TbLabelMapper;
import cn.withmes.common.mode.ResponseData;
import cn.withmes.base.service.TbLabelService;
import cn.withmes.common.utils.UuidUtils;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.base.valid.AddValid;
import cn.withmes.base.valid.UpdateValid;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import cn.withmes.common.web.BaseRestfulController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;


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
 * @description : TbLabel 控制器
 * ---------------------------------
 * @since 2018-11-15
 */
@RestController
@RequestMapping("/label" )
public class TbLabelController extends BaseRestfulController {

    @Autowired
    public TbLabelService tbLabelService;


    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-15
     */
    @RequestMapping(value = "/page" , method = RequestMethod.POST)
    @Cacheable(value = "ten_square.cn.withmes.base.controller.TbLabelController", key = "#id")
    public ResponseData<IPage<TbLabel>> getTbLabelList(@RequestBody TbLabelListVo param,
                                                            @RequestParam(value = "draw" , defaultValue = "0" ) Integer draw,
                                                            @RequestParam(value = "length" ) Integer length,
                                                            @RequestParam(value = "start" ) Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}" , draw, length, start);

        //todo
        if (start >50){

        }
        if (length <0){

        }
        Page<TbLabel> page = new Page<>(start, length);
        IPage<TbLabel> pageList = tbLabelService.page(page, param);
        return successData(pageList);
    }

    /**
     * @description : 通过id获取TbLabel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-15
     */
    @GetMapping(value = "/{labelId}" )
    public ResponseData<TbLabelListVo> getTbLabelById(@PathVariable(name = "labelId") String labelId) {
        TbLabel label = tbLabelService.findById(labelId);
        if (null != label) {
            TbLabelListVo vo = CopyAttributesUtils.copyAtoB(label, TbLabelListVo.class);
            return successData(vo);
        }
        return successData();
    }

    /**
     * @description : 通过id删除TbLabel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-15
     */
    @GetMapping(value = "/deleteById" )
    public ResponseData<Boolean> deleteTbLabelById(String id) {
        /*JSONResult<TbLabel> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tbLabelService.deleteById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:{"+e.getClass().getName()+"}");
        logger.info("异常信息:{}"+e.getMessage());
        }
        return resJson;*/
        return null;
    }

    /**
     * @description : 通过id更新TbLabel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-15
     */
    @PostMapping(value = "/{labelId}" )
    public ResponseData<Boolean> updateTbLabelById(@RequestBody @Validated(value = UpdateValid.class) TbLabel param
            ,@PathVariable(name = "labelId") String labelId) {
        param.setId(labelId);
        int i =  tbLabelService.update(param);
        if (i > 0) {
            return successData();
        }else {
            return ResponseData.builder(ResultCode.FAIL);
        }
    }

    /**
     * @description : 添加TbLabel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-15
     */
    @PostMapping
    public ResponseData<Boolean> addTbLabel(@RequestBody @Validated(value = AddValid.class) TbLabel param) {
        param.setId(UuidUtils.generate());
        param.setState("1");
        int i = tbLabelService.add(param);
        if (i > 0) {
            return successData();
        }else {
            return ResponseData.builder(ResultCode.FAIL);
        }
    }

    /**
     * @description : 标签全部列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-15
     */
    @GetMapping
    public ResponseData<List<TbLabel>> findLableAll() {
        System.out.println(1/0);
        Wrapper<TbLabel> wrapper = new QueryWrapper<>();
        List<TbLabel> list = tbLabelService.findByParams(wrapper);
        return successData(list);
    }

}