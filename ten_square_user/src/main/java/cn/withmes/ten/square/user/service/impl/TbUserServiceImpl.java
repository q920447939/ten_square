package cn.withmes.ten.square.user.service.impl;

import cn.withmes.common.enums.ResultCode;
import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.utils.UuidUtils;
import cn.withmes.common.utils.common.CopyAttributesUtils;
import cn.withmes.ten.square.user.common.RedisCommon;
import cn.withmes.ten.square.user.entity.TbUser;
import cn.withmes.ten.square.user.entity.dto.TbUserDTO;
import cn.withmes.ten.square.user.entity.vo.TbUserListVo;
import cn.withmes.ten.square.user.mapper.TbUserMapper;
import cn.withmes.ten.square.user.service.TbUserService;
import cn.withmes.common.service.BaseServiceImpl;
import cn.withmes.common.dal.BaseMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author leegoo
 * @Description: 用户 服务实现类
 * @date 2018-11-29
 */
@Service
public class TbUserServiceImpl extends BaseServiceImpl<TbUser> implements TbUserService {

    @Autowired
    private TbUserMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public BaseMapper<TbUser> getBaseMapper() {
        return mapper;
    }

    @Override
    public IPage<TbUser> page(Page<TbUserDTO> page, TbUserListVo vo) {
        TbUser dto = CopyAttributesUtils.copyAtoB(vo, TbUser.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<TbUser> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<TbUser> pageList = mapper.selectPage(queryPage, wrapper);
        return pageList;
    }

    @Override
    public ResponseData Register(String mobile) {
        ValueOperations ops = redisTemplate.opsForValue();
        String key = RedisCommon.REDIS_KEY_USER_SMS + mobile;
        if (null != ops.get(key) ) {
            return ResponseData.builder(ResultCode.CODE_EXISTS);
        }
        String numeric = RandomStringUtils.randomNumeric(6);
        ops.set(key, numeric, 60, TimeUnit.SECONDS);
        //消息发送 短信
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("code", numeric);
        rabbitTemplate.convertAndSend("sms", map);
        return ResponseData.successDate();
    }

    @Override
    public ResponseData addTbUser(TbUserDTO e) {
        ValueOperations ops = redisTemplate.opsForValue();
        String key = RedisCommon.REDIS_KEY_USER_SMS + e.getMobile();
        Object code = ops.get(key);
        if (null == code ) {
            return ResponseData.builder(ResultCode.MOBILE_CODE_NOT_EXISTS);
        }
        if (!code.toString().equals(e.getCode())) {
            return ResponseData.builder(ResultCode.MOBILE_CODE_NOT_EXISTS);
        }
        TbUser tbUser = CopyAttributesUtils.copyAtoB(e, TbUser.class);
        tbUser.setId(UuidUtils.generate());
        return add(tbUser) >0 ? ResponseData.successDate() : ResponseData.builder(ResultCode.FAIL);
    }
}
