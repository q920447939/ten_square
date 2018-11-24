/**
 * @Project: 吐槽实现类
 * @Author: leegoo
 * @Date: 2018年11月24日
 */
package cn.withmes.ten.square.spit.service.impl;

import cn.withmes.common.utils.UuidUtils;
import cn.withmes.ten.square.spit.dao.SpitDao;
import cn.withmes.ten.square.spit.entity.Spit;
import cn.withmes.ten.square.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: SpitServiceImpl
 *
 * @author leegoo
 * @Description: 吐槽实现类
 * @date 2018年11月24日
 */
@Service
@Transactional
public class SpitServiceImpl implements SpitService {
    @Autowired
    private SpitDao spitDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Spit> findAll (){
        return  spitDao.findAll();
    }


    @Override
    public Spit findBYId(String id) {
        return spitDao.findById(id).get();
    }

    @Override
    public Spit add(Spit spit) {
        spit.set_id(UuidUtils.generate());
        return spitDao.save(spit);
    }

    @Override
    public Spit update(Spit spit) {
        return spitDao.save(spit);
    }


    @Override
    public Page<Spit> findByParentId (String parentId,int page,int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return spitDao.findSpitByParentId(parentId ,pageable);
    }

    @Override
    public  void thumbUp (String id) {
        Query query  =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }
}
