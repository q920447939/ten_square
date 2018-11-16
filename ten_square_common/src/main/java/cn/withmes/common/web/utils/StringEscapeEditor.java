package cn.withmes.common.web.utils;


import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.beans.PropertyEditorSupport;

/**
 * 
 * @description 与spring mvc的@InitBinder结合 用于防止XSS攻击
 * @author liming
 * @date 2014年3月29日 下午4:24:51
 */
public class StringEscapeEditor extends PropertyEditorSupport {

	// 编码HTML
	private boolean escapeHTML;
	// 编码javascript
	private boolean escapeJavaScript;

	public StringEscapeEditor() {
		super();
	}

	public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript) {
		super();
		this.escapeHTML = escapeHTML;
		this.escapeJavaScript = escapeJavaScript;
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			if (escapeHTML) {
				value = HtmlUtils.htmlEscape(value);
			}
			if (escapeJavaScript) {
				value = JavaScriptUtils.javaScriptEscape(value);
			}
			setValue(value);
		}
	}

}
