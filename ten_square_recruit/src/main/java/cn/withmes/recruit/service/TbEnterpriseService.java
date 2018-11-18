package cn.withmes.recruit.service;

import cn.withmes.common.service.BaseService;
import cn.withmes.recruit.entity.TbEnterprise;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 企业 服务类
 * @author leegoo
 * @date 2018-11-18
 */
public interface TbEnterpriseService extends BaseService<TbEnterprise> {

    IPage<TbEnterprise> page(Page<TbEnterprise> page, TbEnterprise param);
}
