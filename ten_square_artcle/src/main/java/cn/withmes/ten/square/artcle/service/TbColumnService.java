package cn.withmes.ten.square.artcle.service;

import cn.withmes.ten.square.artcle.entity.TbColumn;
import cn.withmes.ten.square.artcle.entity.vo.TbColumnListVo;
import cn.withmes.ten.square.artcle.entity.dto.TbColumnDTO;
import cn.withmes.common.service.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @Description: 专栏 服务类
 * @author leegoo
 * @date 2018-11-22
 */
public interface TbColumnService extends BaseService<TbColumn> {
        IPage<TbColumn> page(Page<TbColumnDTO> page, TbColumnListVo vo);
}
