/**
 * @Project:
 * @Author: liming
 * @Date: 2018年11月18日
 */
package cn.withmes.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;



/**
 * ClassName: TestController
 *
 * @author liming
 * @Description:
 * @date 2018年11月18日
 */
@RestController
public class TestController {

    @Autowired
    private Environment env;

    @Value(value = "${server.port}")
    private String port;


    @GetMapping
    public String aa () {
        return "hello <br> this port is :["+env.getProperty("server.port")+"]";
    }
}
