package cn.withmes.common.enums;

/**
 * @Description:是否启用
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:10
 */
public enum Enabled implements BaseEnum<Enabled, Integer> {

	/**
	 * 不启用
	 */
	NO(0, "不启用"),

	/**
	 * 启用
	 */
	YES(1, "启用");

	/**
	 * 编码
	 */
	private int code;

	/**
	 * 描述
	 */
	private String desc;

	Enabled(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	public String getName() {
		return this.name();
	}

	public Enabled enumValueOf(int code) {
		for (Enabled enabled : Enabled.values()) {
			if (enabled.getCode() == code) {
				return enabled;
			}
		}
		return null;
	}
}
