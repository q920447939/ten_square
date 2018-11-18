package cn.withmes.qa.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * spring cachg 配置
 */
@Configuration
@EnableCaching //加上这个注解是的支持缓存注解
public class SpringCacheConfig {
}
