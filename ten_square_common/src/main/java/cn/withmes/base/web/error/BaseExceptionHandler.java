/**
 * @Project:
 * @Author: liming
 * @Date: 2018年11月09日
 */

package cn.withmes.base.web.error;

import cn.withmes.base.enums.ResultCode;
import cn.withmes.base.mode.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ClassName: MyExceptionHandler
 *
 * @author liming
 * @Description: 自定义异常返回错误页面
 * @date 2018年11月09日
 */

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData MyExceptionHandler(Exception e) {
        e.printStackTrace();
        return ResponseData.builder(null, ResultCode.FAIL, e.getMessage());
    }
}

