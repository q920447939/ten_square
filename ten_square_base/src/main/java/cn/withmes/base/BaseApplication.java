/**
 * @Project:
 * @Author: liming
 * @Date: 2018年11月15日
 */
package cn.withmes.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * ClassName: BaseApplication
 * @Description:
 * @author liming
 * @date 2018年11月15日
 */
@SpringBootApplication
@EnableCaching //加上这个注解是的支持缓存注解
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);

    }
}
