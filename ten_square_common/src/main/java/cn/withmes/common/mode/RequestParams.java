/** 
 *@Project: common-web
 *@Author: liming
 *@Date: 2017年4月14日 
 * 
 */    
package cn.withmes.common.mode;

import java.io.Serializable;

/**
 * @Description:通用参数bean
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:11
 */
public class RequestParams implements Serializable{
	
	private static final long serialVersionUID = -5821675514647619873L;

	/**
	 * 机器码
	 */
	private String machineCode;
	
	/**
	 * 网络类型
	 */
	private String networkType;
	
	/**
	 * 屏幕分辨率
	 */
	private String screen;
	
	/**
	 * 客户端版本号（手机系统）
	 */
	private String clientVersion;
	
	/**
	 * 手机品牌
	 */
	private String brand;
	
	/**
	 * 请求token
	 */
	private String token;
	
	/**
	 * 请求验证串
	 */
	private String deers;
	
	/**
	 * 客户端类型：0:管家APP; 1：微信; 2:POS; 3:便利店APP
	 */
	private String clientType;
	
	/**
	 * APP版本号
	 */
	private String version;
	
	/**
	 * IP
	 */
	private String ip;

	
	public String getMachineCode() {
		return machineCode;
	}

	
	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	
	public String getNetworkType() {
		return networkType;
	}

	
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	
	public String getScreen() {
		return screen;
	}

	
	public void setScreen(String screen) {
		this.screen = screen;
	}

	
	public String getClientVersion() {
		return clientVersion;
	}

	
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	
	public String getBrand() {
		return brand;
	}

	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public String getToken() {
		return token;
	}

	
	public void setToken(String token) {
		this.token = token;
	}


	
	public String getDeers() {
		return deers;
	}


	
	public void setDeers(String deers) {
		this.deers = deers;
	}


	
	public String getClientType() {
		return clientType;
	}


	
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}


	
	public String getVersion() {
		return version;
	}


	
	public void setVersion(String version) {
		this.version = version;
	}


	
	public String getIp() {
		return ip;
	}


	
	public void setIp(String ip) {
		this.ip = ip;
	}
}
