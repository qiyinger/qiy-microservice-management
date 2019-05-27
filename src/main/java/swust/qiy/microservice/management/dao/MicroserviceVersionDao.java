package swust.qiy.microservice.management.dao;

import org.apache.ibatis.annotations.Update;
import swust.qiy.microservice.core.dao.BaseDao;
import swust.qiy.microservice.management.entity.MicroserviceVersion;

/**
 * @author qiying
 */
public interface MicroserviceVersionDao extends BaseDao<MicroserviceVersion> {

  @Update("update microservice_version set configuranted = 1 where id = #{versionId}")
  void configurated(Integer versionId);

}




