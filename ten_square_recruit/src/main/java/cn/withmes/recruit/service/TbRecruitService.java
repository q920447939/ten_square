package cn.withmes.recruit.service;


import cn.withmes.common.service.BaseService;
import cn.withmes.recruit.entity.TbRecruit;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 职位 服务类
 * @author leegoo
 * @date 2018-11-18
 */
public interface TbRecruitService extends BaseService<TbRecruit> {

    IPage<TbRecruit> page(Page<TbRecruit> page, TbRecruit param);

    IPage<TbRecruit> pageByRecommend(Page<TbRecruit> page, TbRecruit param);
}
