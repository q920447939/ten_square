package cn.withmes.ten.square.gathering.service;

import cn.withmes.ten.square.gathering.entity.TbUsergath;
import cn.withmes.common.service.BaseService;
import cn.withmes.ten.square.gathering.entity.dto.TbUsergathDTO;
import cn.withmes.ten.square.gathering.entity.vo.TbUsergathListVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


 /**
 * @Description: 用户关注活动 服务类
 * @author leegoo
 * @date 2018-11-23
 */
public interface TbUsergathService extends BaseService<TbUsergath> {
        IPage<TbUsergath> page(Page<TbUsergathDTO> page, TbUsergathListVO vo);
}
