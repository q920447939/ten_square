/**
 * @Project:
 * @Author: leegoo
 * @Date: 2018年11月30日
 */
package cn.withme.ten.square.sms.listen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName: SmsListen
 * @Description:
 * @author leegoo
 * @date 2018年11月30日
 */
@Component
@RabbitListener(queues="sms")
public class SmsListen {

    @RabbitHandler
    public void getMsg(Map<String, String> map) {
        System.out.println(map);
    }
}
