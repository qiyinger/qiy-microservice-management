package swust.qiy.microservice.management.dao;

import org.apache.ibatis.annotations.Select;
import swust.qiy.microservice.core.dao.BaseDao;
import swust.qiy.microservice.management.entity.Microservice;

/**
 * @author qiying
 */
public interface MicroserviceDao extends BaseDao<Microservice> {

  /**
   * 统计allCode
   */
  @Select("count(id) from microservice where all_code = #{allCode}")
  int countByAllCode(String allCode);

}




