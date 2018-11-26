/** 
 *@Project: mall-trade-core 
 *@Author: leegoo
 *@Date: 2018年4月19日 
 *@Copyright: ©2014-2020 www.haokukeji.com Inc. All rights reserved. 
 */
package cn.withmes.common.mode;

import java.io.Serializable;

/**
 * @Description:HeaderInfo
 * @param:
 * @return:
 * @auther: leegoo
 * @date: 2018/5/19 11:11
 */
public class HeaderInfo implements Serializable {

	private static final long serialVersionUID = -1037723362471069471L;

	/**
	 * 设备ID
	 */
	private String clientId;
	
	/**
	 * 客户端类型（0：android,1：ios,2：小程序，3：公众号）
	 */
	private String clientType;
	
	/**
	 * 客户端详情(系统类型，系统版本等)
	 */
	private String clientAgent;
	
	/**
	 * 用户token
	 */
	private String token;
	
	/**
	 * app版本
	 */
	private String version;
	
	/**
	 * 屏幕分辨率
	 */
	private String screen;
	
	/**
	 * 签名
	 */
	private String sign;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getClientAgent() {
		return clientAgent;
	}

	public void setClientAgent(String clientAgent) {
		this.clientAgent = clientAgent;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
