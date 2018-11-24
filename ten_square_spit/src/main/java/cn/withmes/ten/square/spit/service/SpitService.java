/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月24日
 */
package cn.withmes.ten.square.spit.service;

import cn.withmes.ten.square.spit.entity.Spit;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * ClassName: SpitService
 * @Description:
 * @author leegoo
 * @date 2018年11月24日
 */
public interface SpitService {
     List<Spit> findAll ();

     Spit findBYId(String id);

     Spit add (Spit spit);

     Spit update(Spit spit);

     Page<Spit> findByParentId (String parentId ,int page,int size);

     void thumbUp (String id);
}
