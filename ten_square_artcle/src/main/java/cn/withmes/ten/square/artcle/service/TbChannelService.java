package cn.withmes.ten.square.artcle.service;

import cn.withmes.common.service.BaseService;
import cn.withmes.ten.square.artcle.entity.TbChannel;
import cn.withmes.ten.square.artcle.entity.vo.TbChannelListVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @Description: 频道 服务类
 * @author leegoo
 * @date 2018-11-21
 */
public interface TbChannelService extends BaseService<TbChannel> {
        IPage<TbChannel> page(Page<TbChannel> page, TbChannelListVo vo);
}
