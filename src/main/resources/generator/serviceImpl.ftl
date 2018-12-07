package ${package};

import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import ${tableClass.fullClassName};
import swust.qiy.microservice.management.service.${tableClass.shortClassName}Service;

/**
 * @author qiying
 */
@Service
public class ${tableClass.shortClassName}${mapperSuffix} extends BaseServiceImpl<${tableClass.shortClassName}> implements ${tableClass.shortClassName}Service {

}
