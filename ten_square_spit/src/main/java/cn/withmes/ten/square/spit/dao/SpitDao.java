/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月24日
 */
package cn.withmes.ten.square.spit.dao;

import cn.withmes.ten.square.spit.entity.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

/**
 * ClassName: SpitDao
 * @Description:
 * @author leegoo
 * @date 2018年11月24日
 */
public interface SpitDao extends MongoRepository<Spit,String> {

     Page<Spit> findSpitByParentId(String parentId, Pageable pageable);
}
