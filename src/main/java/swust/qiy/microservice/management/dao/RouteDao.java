package swust.qiy.microservice.management.dao;

import org.apache.ibatis.annotations.Update;
import swust.qiy.microservice.core.dao.BaseDao;
import swust.qiy.microservice.management.entity.Route;

/**
 * @author qiying
 */
public interface RouteDao extends BaseDao<Route> {

  @Update("update route set status = #{status} where gateway_id = #{gatewayId}")
  void updateAllStatus(int gatewayId, int status);

}




