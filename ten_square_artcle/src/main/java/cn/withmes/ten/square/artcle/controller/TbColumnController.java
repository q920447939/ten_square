package cn.withmes.ten.square.artcle.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.ten.square.artcle.entity.dto.TbColumnDTO;
import cn.withmes.ten.square.artcle.entity.vo.TbColumnAddVo;
import cn.withmes.ten.square.artcle.entity.vo.TbColumnListVo;
import cn.withmes.ten.square.artcle.entity.vo.TbColumnUpdateVo;
import cn.withmes.ten.square.artcle.entity.vo.TbColumnVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.RestController;
import cn.withmes.common.web.BaseRestfulController;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.withmes.ten.square.artcle.service.TbColumnService;

import cn.withmes.ten.square.artcle.entity.TbColumn;
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
 *   @description : TbColumn 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-22
 */
@RestController
@RequestMapping("/tb-column")
public class TbColumnController extends BaseRestfulController {

    @Autowired
    public TbColumnService tbColumnService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-22
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbColumnListVo>> getTbColumnList(
                @RequestBody TbColumnListVo param ,
                @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                @RequestParam(value = "length") Integer length,
                @RequestParam(value = "start") Integer start) {
            log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
            Page<TbColumnDTO> page = new Page<>(draw, length);
            IPage<TbColumn> pageList = tbColumnService.page(page, param);
            IPage<TbColumnListVo> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
            return successData(iPage);
    }

    /**
     * @description : 通过id获取TbColumn
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-22
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<TbColumnVo> getTbColumnById(@PathVariable(name = "id") String id) {
        TbColumn dto = tbColumnService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,TbColumnVo.class));
    }

    /**
     * @description : 通过id删除TbColumn
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-22
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTbColumnById(@PathVariable(name = "id") String id) {
        log.info("deleteTbColumnById.id:{}",id);
        return successData( tbColumnService.delete(id));
    }

    /**
     * @description : 通过id更新TbColumn
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-22
     */
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTbColumnById(@RequestBody  @Validated(value = UpdateValid.class) TbColumnUpdateVo param) {
        log.info("updateTbColumnById.param:{}",param);
        TbColumn e = CopyAttributesUtils.copyAtoB(param, TbColumn.class);
        return successData(tbColumnService.update(e));
    }

    /**
     * @description : 添加TbColumn
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-22
     */
    @PostMapping(value = "/add")
    public ResponseData<Integer> addTbColumn(@RequestBody @Validated(value = AddValid.class) TbColumnAddVo param) {
        log.info("addTbColumn.param:{}",param);
         TbColumn e = CopyAttributesUtils.copyAtoB(param, TbColumn.class);
        return successData(tbColumnService.add(e));
    }
}