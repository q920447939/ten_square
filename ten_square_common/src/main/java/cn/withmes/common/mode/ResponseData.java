/** 
 *@Project: common-common
 *@Author: leegoo
 *@Date: 2017年5月10日 
 * 
 */
package cn.withmes.common.mode;


import cn.withmes.common.enums.ResultCode;
import cn.withmes.common.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @Description: 客户端响应实体
 *  *	{
 *  *		data: {
 *  *
 *  *		},
 *  *		code: Integer,
 *  *		message: ""
 *  *	}
 * @param:
 * @return:
 * @auther: leegoo
 * @date: 2018/5/19 11:12
 */
public class ResponseData<T> implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = -4523061141121419191L;

	private T data;

	private String message;

	private Integer code;

	public static <E> ResponseData<E> builder(ResultEnum<Integer> resultCode) {
	    return new ResponseData<E>(resultCode);
	}
	
	public static <E> ResponseData<E> builder(E data, ResultEnum<Integer> resultCode) {
		return new ResponseData<E>(resultCode, data);
	}
	
	public static <E> ResponseData<E> builder(E data, ResultEnum<Integer> result,String message) {
		return new ResponseData<E>(result.getCode(),message, data);
	}

	/**
	 * <p>Title: 构造方法1</p> 
	 * <p>Description:无参 </p>
	 */
	public ResponseData() {
		this(ResultCode.SUCCESS);
	}

	/**
	 * 构造方法2
	 * @param result
	 */
	public ResponseData(ResultEnum<Integer> result) {
		this.code = result.getCode();
		this.message = result.getDesc();
	}

	/**
	 * 构造方法3
	 * @param result
	 * @param data
	 */
	private ResponseData(ResultEnum<Integer> result, T data) {
		this.code = result.getCode();
		this.message = result.getDesc();
		this.data = data;
	}

	/**
	 * 构造方法4
	 * @param result
	 * @param data
	 */
	private ResponseData(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * @Description: ResponseData中Data对象转换
	 * @param destinationClass
	 * @return  
	 * @author leegoo
	 * @date 2017年11月8日
	 */
/*	public <E> ResponseData<E> map(Class<E> destinationClass) {
		ResponseData<E> response = new ResponseData<E>();
		response.setCode(code);
		response.setMessage(message);
		response.setData(BeanMapper.map(this.data, destinationClass));
		return response;
	}
	*/
	/**
	 * 判断是否成功
	 * @return   
	 * @author leegoo
	 * @date 2018年1月8日
	 */
	@JsonIgnore
	public boolean isSuccess() {
		return ResultCode.SUCCESS.getCode().equals(this.code);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public void setResult(ResultEnum<Integer> result) {
	    this.code = result.getCode();
	    this.message = result.getDesc();
	}
	
	public void setResult(Integer code,String message) {
	    this.code = code;
	    this.message = message;
	}


}
