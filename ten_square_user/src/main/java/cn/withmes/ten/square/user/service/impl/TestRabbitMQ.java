/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月30日
 */
package cn.withmes.ten.square.user.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Map;

/**
 * ClassName: TestRabbitMQ
 * @Description:
 * @author leegoo
 * @date 2018年11月30日
 */
@RabbitListener(queues="")
public class TestRabbitMQ {

    @RabbitHandler
    public  void getMsg (Map<String, Object> map) {
        System.out.println("收到的消息:"+map);
    }
}
