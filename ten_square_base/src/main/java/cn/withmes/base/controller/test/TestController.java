/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月16日
 */
package cn.withmes.base.controller.test;

import cn.withmes.base.entity.TbLabel;
import cn.withmes.base.service.TbLabelService;
import cn.withmes.common.redis.RedisCache;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName: TestController
 * @Description:
 * @author leegoo
 * @date 2018年11月16日
 */
@RestController()
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TbLabelService service;


    @GetMapping(value = "/{id}")
    @Cacheable(value = "post-single", key = "#id")
    public TbLabel login(@PathVariable(name = "id",required = false) String id ){
        TbLabel dto = service.findById(id);
        return dto;
    }

}
