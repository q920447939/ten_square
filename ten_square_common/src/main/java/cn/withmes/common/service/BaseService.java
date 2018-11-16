package cn.withmes.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper ;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: IBaseService 
 * @Description: 业务实现层接口
 * 所有的method方法以动词命名开头:<br/>
 * find*:查询<br/>
 * update*:修改<br/>
 * add*:添加<br/>
 * delete*:删除<br/>
 * @author liming
 * @date 2018年3月20日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
public interface BaseService<T> {

	/**
	 * DESC: 添加单个实体
	 * @param entity
	 * @return
	 */
	int add(T entity);

	/**
	 * DESC: 根据ID修改实体
	 * @author liming
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(T entity);
	
	/**
	 * @Description: 更新全部字段
	 * @param entity
	 * @return   
	 * @author liming
	 * @date 2018年5月11日
	 */
	int updateAllColumn(T entity);

	/**
	 * DESC: 根据ID删除单个实体
	 * @author liming
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int delete(Serializable id);

	/**
	 * DESC: 根据ID加载单个实体
	 * @author liming
	 * @param id
	 * @return
	 * @throws Exception
	 */
	T findById(Serializable id);

	/**
	 * DESC: 根据ID列表查询
	 * @param idList ID列表
	 * @return
	 * @throws Exception   
	 * @author liming
	 * @date 2017年12月12日
	 */
	List<T> findBatchIds(Collection<? extends Serializable> idList);

	/**
	 * DESC: 根据参数条件查询
	 * @author liming
	 * @param params
	 * @return
	 * @throws Exception
	 */
//	List<T> findByParams(Map<String, Object> params);

	/**
	 * DESC: 根据条件查找对象列表
	 * @param entity
	 * @return   
	 * @author liming
	 * @date 2017年12月12日
	 */
	List<T> findByParams(Wrapper<T> wrapper);

	/**
	 * @Description: 查询统计
	 * @param entity
	 * @return   
	 * @author liming
	 * @date 2017年12月12日
	 */
	Integer findCount(Wrapper<T> wrapper);

}
