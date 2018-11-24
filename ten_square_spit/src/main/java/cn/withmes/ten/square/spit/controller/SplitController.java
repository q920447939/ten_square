/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月24日
 */
package cn.withmes.ten.square.spit.controller;

import cn.withmes.common.enums.ResultCode;
import cn.withmes.common.mode.ResponseData;
import cn.withmes.common.web.BaseRestfulController;
import cn.withmes.ten.square.spit.entity.Spit;
import cn.withmes.ten.square.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: TestMongoController
 *
 * @author leegoo
 * @Description:
 * @date 2018年11月24日
 */
@RestController
@CrossOrigin
@RequestMapping("spit")
public class SplitController extends BaseRestfulController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/all")
    public List<Spit> testMongdo() {
        return spitService.findAll();

    }

    @GetMapping("/get/{id}")
    public Spit getById(@PathVariable(name = "id") String id) {
        return spitService.findBYId(id);
    }

    @PostMapping("add")
    public Spit add(@RequestBody Spit spit) {
        return spitService.add(spit);
    }

    @PostMapping("update")
    public Spit update(@RequestBody Spit spit) {
        return spitService.update(spit);
    }


    @GetMapping("/get/parent/{parentId}")
    public ResponseData<Page<Spit>> findByParentId(
            @PathVariable(name = "parentId") String parentId,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "30") Integer size
    ) {
        return successData(spitService.findByParentId(parentId, page, size));
    }


    @GetMapping("/thumpUp/{id}")
    public ResponseData thumpUp(@PathVariable(name = "id") String id ) {
        //todo 取 user id
        String userid = "123";
        String key = "thump_"+id+"_"+userid;
        if (null !=redisTemplate.opsForValue().get(key)) return ResponseData.builder(null,ResultCode.FAIL,"不能重复点赞");
        spitService.thumbUp(id);
        redisTemplate.opsForValue().set(key,1);
        return successData();
    }


}
