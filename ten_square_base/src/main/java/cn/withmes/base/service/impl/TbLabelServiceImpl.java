package cn.withmes.base.service.impl;

import cn.withmes.base.entity.TbLabel;
import cn.withmes.base.entity.vo.TbLabelListVo;
import cn.withmes.base.mapper.TbLabelMapper;
import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.base.service.TbLabelService;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author leegoo
 * @Description: 标签 服务实现类
 * @date 2018-11-15
 */
@Service
public class TbLabelServiceImpl extends BaseServiceImpl<TbLabel> implements TbLabelService {

    @Autowired
    private TbLabelMapper mapper;

    @Override
    public BaseMapper<TbLabel> getBaseMapper() {
        return mapper;
    }

    @Override
    public  IPage<TbLabel> page(Page<TbLabel> page, TbLabelListVo vo) {
        TbLabel dto = CopyAttributesUtils.copyAtoB(vo, TbLabel.class);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("state",dto.getState());
        IPage<TbLabel> userIPage = mapper.selectPage(page, wrapper);
        return userIPage;
    }
}

