package cn.withmes.ten.square.gathering.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.ten.square.gathering.entity.dto.TbUsergathDTO;
import cn.withmes.ten.square.gathering.entity.vo.TbUsergathListVO;
import cn.withmes.ten.square.gathering.entity.vo.TbUsergathUpdateVO;
import cn.withmes.ten.square.gathering.entity.vo.TbUsergathVO;
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

import cn.withmes.ten.square.gathering.service.TbUsergathService;

import cn.withmes.ten.square.gathering.entity.TbUsergath;
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
 *   @description : TbUsergath 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-23
 */
@RestController
@RequestMapping("/tb-usergath")
public class TbUsergathController extends BaseRestfulController {

    @Autowired
    public TbUsergathService tbUsergathService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbUsergathListVO>> getTbUsergathList(
                @RequestBody TbUsergathListVO param ,
                @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                @RequestParam(value = "length") Integer length,
                @RequestParam(value = "start") Integer start) {
            log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
            Page<TbUsergathDTO> page = new Page<>(draw, length);
            IPage<TbUsergath> pageList = tbUsergathService.page(page, param);
            IPage<TbUsergathListVO> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
            return successData(iPage);
    }

    /**
     * @description : 通过id获取TbUsergath
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<TbUsergathVO> getTbUsergathById(@PathVariable(name = "id") String id) {
        TbUsergath dto = tbUsergathService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,TbUsergathVO.class));
    }

    /**
     * @description : 通过id删除TbUsergath
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTbUsergathById(@PathVariable(name = "id") String id) {
        log.info("deleteTbUsergathById.id:{}",id);
        return successData( tbUsergathService.delete(id));
    }

    /**
     * @description : 通过id更新TbUsergath
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTbUsergathById(@RequestBody  @Validated(value = UpdateValid.class) TbUsergathUpdateVO param) {
        log.info("updateTbUsergathById.param:{}",param);
        TbUsergath e = CopyAttributesUtils.copyAtoB(param, TbUsergath.class);
        return successData(tbUsergathService.update(e));
    }

    /**
     * @description : 添加TbUsergath
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @PostMapping(value = "/add")
    public ResponseData<Integer> addTbUsergath(@RequestBody @Validated(value = AddValid.class) TbUsergathUpdateVO param) {
        log.info("addTbUsergath.param:{}",param);
         TbUsergath e = CopyAttributesUtils.copyAtoB(param, TbUsergath.class);
        return successData(tbUsergathService.add(e));
    }
}