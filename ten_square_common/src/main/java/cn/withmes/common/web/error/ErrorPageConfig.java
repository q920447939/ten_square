/**
 * @Project: 配置错误页面
 * @Author: leegoo
 * @Date: 2018年11月09日
 */
package cn.withmes.common.web.error;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 错误页面的配置
 */
@Configuration
public class ErrorPageConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error.html");
                ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
                ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-500.html");
                factory.addErrorPages(errorPage400,errorPage404,errorPage500);
               // factory.setPort(8080);
            }
        };
    }
}