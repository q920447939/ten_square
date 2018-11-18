/**
 * @Project:
 * @Author: liming
 * @Date: 2018年11月18日
 */
package cn.withmes.recruit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 *
 * @author liming
 * @Description:
 * @date 2018年11月18日
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/a")
    public String aa () {
        return "hello";
    }
}
