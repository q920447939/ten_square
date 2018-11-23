package cn.withmes.ten.square.artcle.controller;


import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.ten.square.artcle.entity.TbChannel;
import cn.withmes.ten.square.artcle.entity.vo.TbChannelAddVo;
import cn.withmes.ten.square.artcle.entity.vo.TbChannelListVo;
import cn.withmes.ten.square.artcle.entity.vo.TbChannelUpdateVo;
import cn.withmes.ten.square.artcle.entity.vo.TbChannelVo;
import cn.withmes.ten.square.artcle.service.TbChannelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

import org.springframework.web.bind.annotation.RequestBody;


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
 * @description : TbChannelVo 控制器
 * ---------------------------------
 * @since 2018-11-21
 */
@RestController
@RequestMapping("/tb-channel")
public class TbChannelController extends BaseRestfulController {

    @Autowired
    public TbChannelService tbChannelService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbChannelListVo>> getTbChannelList(
            @RequestBody TbChannelListVo param,
            @RequestParam(value = "draw", defaultValue = "0") Integer draw,
            @RequestParam(value = "length") Integer length,
            @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}", draw, length, start);
        Page<TbChannel> page = new Page<>(draw, length);
        IPage<TbChannel> pageList = tbChannelService.page(page, param);
        IPage<TbChannelListVo> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
        return successData(iPage);
    }

    /**
     * @description : 通过id获取TbChannel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<TbChannelVo> getTbChannelById(@PathVariable(name = "id") String id) {
        TbChannel dto = tbChannelService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto, TbChannelVo.class));
    }

    /**
     * @description : 通过id删除TbChannel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTbChannelById(@PathVariable(name = "id") String id) {
        log.info("deleteTbChannelById.id:{}", id);
        return successData(tbChannelService.delete(id));
    }

    /**
     * @description : 通过id更新TbChannel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTbChannelById(@RequestBody @Validated(value = UpdateValid.class) TbChannelUpdateVo param) {
        log.info("updateTbChannelById.param:{}", param);
        TbChannel e = CopyAttributesUtils.copyAtoB(param, TbChannel.class);

        return successData(tbChannelService.update(e));
    }

    /**
     * @description : 添加TbChannel
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-21
     */
    @PostMapping(value = "/add")
    public ResponseData<Integer> addTbChannel(@RequestBody @Validated(value = AddValid.class) TbChannelAddVo param) {
        log.info("addTbChannel.param:{}", param);
        TbChannel e = CopyAttributesUtils.copyAtoB(param, TbChannel.class);
        return successData(tbChannelService.add(e));
    }
}