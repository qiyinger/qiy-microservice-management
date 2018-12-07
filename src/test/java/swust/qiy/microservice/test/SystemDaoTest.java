package swust.qiy.microservice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.management.ManagementApp;
import swust.qiy.microservice.management.dao.SystemDao;
import swust.qiy.microservice.management.entity.System;
import swust.qiy.microservice.management.service.SystemService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qiying
 * @create 2018/11/20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManagementApp.class)
public class SystemDaoTest {

    @Resource
    private SystemDao systemDao;

    @Autowired
    private SystemService systemService;


    @Test
    public void test() {

    }


}
