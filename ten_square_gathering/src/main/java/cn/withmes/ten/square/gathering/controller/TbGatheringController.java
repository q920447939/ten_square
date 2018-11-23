package cn.withmes.ten.square.gathering.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.ten.square.gathering.entity.dto.TbGatheringDTO;
import cn.withmes.ten.square.gathering.entity.vo.TbGatheringAddVO;
import cn.withmes.ten.square.gathering.entity.vo.TbGatheringListVO;
import cn.withmes.ten.square.gathering.entity.vo.TbGatheringUpdateVO;
import cn.withmes.ten.square.gathering.entity.vo.TbGatheringVO;
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

import cn.withmes.ten.square.gathering.service.TbGatheringService;

import cn.withmes.ten.square.gathering.entity.TbGathering;
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
 *   @description : TbGathering 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2018-11-23
 */
@RestController
@RequestMapping("/tb-gathering")
public class TbGatheringController extends BaseRestfulController {

    @Autowired
    public TbGatheringService tbGatheringService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbGatheringListVO>> getTbGatheringList(
                @RequestBody TbGatheringListVO param ,
                @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                @RequestParam(value = "length") Integer length,
                @RequestParam(value = "start") Integer start) {
            log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
            Page<TbGatheringDTO> page = new Page<>(draw, length);
            IPage<TbGathering> pageList = tbGatheringService.page(page, param);
            IPage<TbGatheringListVO> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
            return successData(iPage);
    }

    /**
     * @description : 通过id获取TbGathering
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<TbGatheringVO> getTbGatheringById(@PathVariable(name = "id") String id) {
        TbGathering dto = tbGatheringService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,TbGatheringVO.class));
    }

    /**
     * @description : 通过id删除TbGathering
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTbGatheringById(@PathVariable(name = "id") String id) {
        log.info("deleteTbGatheringById.id:{}",id);
        return successData( tbGatheringService.delete(id));
    }

    /**
     * @description : 通过id更新TbGathering
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTbGatheringById(@RequestBody  @Validated(value = UpdateValid.class) TbGatheringUpdateVO param) {
        log.info("updateTbGatheringById.param:{}",param);
        TbGathering e = CopyAttributesUtils.copyAtoB(param, TbGathering.class);
        return successData(tbGatheringService.update(e));
    }

    /**
     * @description : 添加TbGathering
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-23
     */
    @PostMapping(value = "/add")
    public ResponseData<Integer> addTbGathering(@RequestBody @Validated(value = AddValid.class) TbGatheringAddVO param) {
        log.info("addTbGathering.param:{}",param);
         TbGathering e = CopyAttributesUtils.copyAtoB(param, TbGathering.class);
        return successData(tbGatheringService.add(e));
    }
}