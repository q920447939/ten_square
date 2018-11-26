package cn.withmes.common.exception;


import cn.withmes.common.enums.ResultCode;
import cn.withmes.common.enums.ResultEnum;

/**
 * @Description:业务异常
 * @param:
 * @return:
 * @auther: leegoo
 * @date: 2018/5/19 11:11
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    /**
     * 异常编码
     */
    private ResultEnum<Integer> code = ResultCode.BUSINESS_ERROR;

    private Object data;


    public ResultEnum<Integer> getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public BusinessException(ResultEnum<Integer> code, String message, Throwable cause) {
        this(message, cause);
        this.code = code;
    }

    public BusinessException(ResultEnum<Integer> code, String message) {
        super(message);
        this.code = code;
    }


    public BusinessException(ResultEnum<Integer> code) {
        this(code, code.getDesc());
    }



    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BusinessException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public BusinessException withData(Object data) {
        this.data = data;
        return this;
    }

}
