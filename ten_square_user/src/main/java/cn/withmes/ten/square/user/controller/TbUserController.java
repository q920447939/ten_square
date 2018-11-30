package cn.withmes.ten.square.user.controller;


import cn.withmes.common.enums.ResultCode;
import cn.withmes.common.enums.ResultEnum;
import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.StringUtils;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.common.utils.mapper.BeanMapper;
import cn.withmes.common.valid.AddValid;
import cn.withmes.common.valid.UpdateValid;
import cn.withmes.ten.square.user.entity.dto.TbUserDTO;
import cn.withmes.ten.square.user.entity.vo.TbUserAddVo;
import cn.withmes.ten.square.user.entity.vo.TbUserListVo;
import cn.withmes.ten.square.user.entity.vo.TbUserUpdateVo;
import cn.withmes.ten.square.user.entity.vo.TbUserVO;
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

import cn.withmes.ten.square.user.service.TbUserService;

import cn.withmes.ten.square.user.entity.TbUser;
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
 * @description : TbUser 控制器
 * ---------------------------------
 * @since 2018-11-29
 */
@RestController
@RequestMapping("/tbUser")
public class TbUserController extends BaseRestfulController {

    @Autowired
    public TbUserService tbUserService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-29
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<TbUserListVo>> getTbUserList(
            @RequestBody TbUserListVo param,
            @RequestParam(value = "draw", defaultValue = "0") Integer draw,
            @RequestParam(value = "length") Integer length,
            @RequestParam(value = "start") Integer start) {
        log.info("getTbLabelList.draw:{}.length:{}.start:{}", draw, length, start);
        Page<TbUserDTO> page = new Page<>(draw, length);
        IPage<TbUser> pageList = tbUserService.page(page, param);
        IPage<TbUserListVo> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
        return successData(iPage);
    }

    /**
     * @description : 通过id获取TbUser
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-29
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<TbUserVO> getTbUserById(@PathVariable(name = "id") String id) {
        TbUser dto = tbUserService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto, TbUserVO.class));
    }

    /**
     * @description : 通过id删除TbUser
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-29
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTbUserById(@PathVariable(name = "id") String id) {
        log.info("deleteTbUserById.id:{}", id);
        return successData(tbUserService.delete(id));
    }

    /**
     * @description : 通过id更新TbUser
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-29
     */
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTbUserById(@RequestBody @Validated(value = UpdateValid.class) TbUserUpdateVo param) {
        log.info("updateTbUserById.param:{}", param);
        TbUser e = CopyAttributesUtils.copyAtoB(param, TbUser.class);
        return successData(tbUserService.update(e));
    }

    /**
     * @description : 添加TbUser
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2018-11-29
     */
    @PostMapping(value = "/add")
    public ResponseData<Integer> addTbUser(@RequestBody @Validated(value = AddValid.class) TbUserAddVo param) {
        log.info("addTbUser.param:{}", param);
        if (!StringUtils.isNotBlank(param.getCode())) {
            return failParamData();
        }
        TbUserDTO e = CopyAttributesUtils.copyAtoB(param, TbUserDTO.class);
        ResponseData responseData = tbUserService.addTbUser(e);
        return responseData.isSuccess() == true ? successData() : failParamData();
    }


    @GetMapping("/register/{mobile}")
    public ResponseData<Object> Register(@PathVariable(name = "mobile") String mobile) {
        ResponseData serviceDate = tbUserService.Register(mobile);
        if (!serviceDate.isSuccess()) {
            return serviceDate;
        } else {
            return successData();
        }
    }
}