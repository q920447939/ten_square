package cn.withmes.ten.square.user.service;

import cn.withmes.common.mode.ResponseData;
import cn.withmes.ten.square.user.entity.TbUser;
import cn.withmes.ten.square.user.entity.dto.TbUserDTO;
import cn.withmes.ten.square.user.entity.vo.TbUserListVo;
import cn.withmes.common.service.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


 /**
 * @Description: 用户 服务类
 * @author leegoo
 * @date 2018-11-29
 */
public interface TbUserService extends BaseService<TbUser> {
     IPage<TbUser> page(Page<TbUserDTO> page, TbUserListVo vo);

     ResponseData Register(String mobile);

     ResponseData addTbUser(TbUserDTO e);
 }
