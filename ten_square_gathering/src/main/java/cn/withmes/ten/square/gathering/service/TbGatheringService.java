package cn.withmes.ten.square.gathering.service;

import cn.withmes.ten.square.gathering.entity.TbGathering;
import cn.withmes.ten.square.gathering.entity.dto.TbGatheringDTO;
import cn.withmes.ten.square.gathering.entity.vo.TbGatheringListVO;
import cn.withmes.common.service.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


 /**
 * @Description: 活动 服务类
 * @author leegoo
 * @date 2018-11-23
 */
public interface TbGatheringService extends BaseService<TbGathering> {
        IPage<TbGathering> page(Page<TbGatheringDTO> page, TbGatheringListVO vo);
}
