/**
 *
 */
package cn.withmes.common.utils.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤输入：例如emoji表情等的工具类
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: xfxb-common-component
 * copyright:
 * createTime:
 * modifyTime:
 * modifyBy:
 */
public final class InputFilterUtil {

    static Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

    /**
     * @param source
     * @return
     */
    public static CharSequence filterEmoji(CharSequence source) {
        Matcher emojiMatcher = emoji.matcher(source);
        if (emojiMatcher.find()) {
            return "";
        }
        return null;
    }

}
