package cn.withmes.ten.square.spit;

import cn.withmes.ten.square.spit.entity.Spit;
import cn.withmes.ten.square.spit.service.SpitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class TenSquareSpitApplicationTests {

    @Autowired
    private SpitService spitService;


    @Test
    public void contextLoads() {
        List<Spit> list = spitService.findAll();
        System.out.println(list);
    }

}
