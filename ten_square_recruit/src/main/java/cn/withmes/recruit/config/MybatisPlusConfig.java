package cn.withmes.recruit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author miemie
 * @since 2018-08-12
 */
@Configuration
@MapperScan("cn.withmes.base.mapper")
public class MybatisPlusConfig {

}
