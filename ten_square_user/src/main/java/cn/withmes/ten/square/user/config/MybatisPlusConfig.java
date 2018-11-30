package cn.withmes.ten.square.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author miemie
 * @since 2018-08-12
 */
@Configuration
@MapperScan("cn.withmes.ten.square.user.mapper*")
public class MybatisPlusConfig {

}
