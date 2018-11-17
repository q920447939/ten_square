package cn.withmes.base.service;


import cn.withmes.base.entity.TbLabel;
import cn.withmes.base.entity.vo.TbLabelListVo;
import cn.withmes.common.service.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author leegoo
 * @since 2018-11-15
 */
public interface TbLabelService extends BaseService<TbLabel> {

    IPage<TbLabel> page (Page<TbLabel> page, TbLabelListVo vo);

}