package cn.withmes.recruit.service.impl;


import cn.withmes.common.dal.BaseMapper;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.common.utils.StringUtils;
import cn.withmes.recruit.entity.TbRecruit;
import cn.withmes.recruit.mapper.TbRecruitMapper;
import cn.withmes.recruit.service.TbRecruitService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author leegoo
 * @Description: 职位 服务实现类
 * @date 2018-11-18
 */
@Service
public class TbRecruitServiceImpl extends BaseServiceImpl<TbRecruit> implements TbRecruitService {

    @Autowired
    private TbRecruitMapper mapper;

    @Override
    public BaseMapper<TbRecruit> getBaseMapper() {
        return mapper;
    }

    @Override
    public IPage<TbRecruit> page(Page<TbRecruit> page, TbRecruit param) {
        QueryWrapper wrapper = new QueryWrapper();
        if (StringUtils.isNotBlank(param.getState())) {
            wrapper.eq("state", param.getState());
        }
        wrapper.orderByDesc("createtime");
        IPage<TbRecruit> userIPage = mapper.selectPage(page, wrapper);
        return userIPage;
    }

    @Override
    public IPage<TbRecruit> pageByRecommend(Page<TbRecruit> page, TbRecruit param) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("state", "1", "2");
        wrapper.orderByDesc("createtime");
        IPage<TbRecruit> userIPage = mapper.selectPage(page, wrapper);
        return userIPage;
    }
}
