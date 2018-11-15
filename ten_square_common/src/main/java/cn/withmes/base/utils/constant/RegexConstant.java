package cn.withmes.base.utils.constant;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
public class RegexConstant {
    /**
     * 中文编码
     */
    public static String CHINESE = "[\u4e00-\u9fa5]*";
    /**
     * 邮箱
     */
    public static String EMAIL = "([A-Za-z0-9]*[-_]?[A-Za-z0-9]+)*@([A-Za-z0-9]*[-_]?[A-Za-z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
    /**
     * url
     */
    public static String URL = "((http|ftp|https):\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
    /**
     * 普通文本
     */
    //public static String TEXT = "[a-zA-Z0-9\u4e00-\u9fa5?!！：:,，。.   \n]+$";
    //public static String TEXT = "[a-zA-Z0-9\u2E80-\u9FFFh?!！：:,，。.   \n]+$";
    //public static String TEXT = "[a-zA-Z0-9\u2E80-\u9FFF]+$";
    // 添加~-－，支持时间格式及配送时间格式输出 update at 2017-12-111套（生日派对包）(1磅+生日派对礼包)
    public static String TEXT = "[a-zA-Z0-9\\u2E80-\\u9FFFh?!！~\\\\-－：:,，。.   \\n]+$";
    /**
     * 合法文本排查utf8字符 \u0000-\uFFFF
     */
    //团购网站,美团网/大众点评
    public static String VALID_TEXT = "[a-zA-Z0-9\\u2E80-\\u9FFFh?!！~\\\\-－：:,，。.+=（）()/   \\n]+$";

    /**
     * 数字
     */
    public static String NUMBER = "[0-9]\\d*$";


    /**
     * 标点符号
     */
    public static  String CHARACTER  = "[\\p{Punct}]+";


    /**
     * 小数
     */
    public static String DOUBLE = "[0-9]+(.[0-9]*)?$";
    /**
     * 英文
     */
    public static String ENGLISH = "[a-zA-Z]*";
    /**
     * 手机号
     */
//    public static String PHONENO = "^(0\\d{2,3}\\d{5,9}|0\\d{2,3}\\d{5,9})|(^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(16[0-9])|(17[0,1,3,5-9])|(18[0-9])|(19[0-9]))\\d{8})|(^86((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(17[0,1,3,5-9])|(18[0-9])|(19[0-9]))\\d{8})$";

    /**
     * 支持隐私号模糊匹配，update 20180531
     */
    public static String PHONENO = "^(0\\d{2,3}\\d{5,9}|0\\d{2,3}\\d{5,9})|(^1\\d{10})|(^1\\d{10}[-,_#]\\d{1,5})|(^861\\d{10})$";

    /**
     * 隐私号匹配
     */
    public static String PRIVACY_PHONENO = "(^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(16[0-9])|(17[0,1,3,5-9])|(18[0-9])|(19[0-9]))\\d{8}[-,_#]\\d{1,5})$";

    /**
     * 座机号
     */
    public static String FIXEDPHONENO = "^0\\d{2,3}-?\\d{7,8}$";
    /**
     * 密码:字母和数字的8-20位字符
     */
    public static String PASSWORD_ALPHANUMERIC8TO20 = "(?!^\\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{8,20}";
    /**
     * 用户昵称最大10个长度
     */
    public static String NICKNAME_10LENGTH = "[a-zA-Z0-9\u2E80-\u9FFFh?!！：:,，。.   \n]{1,20}";
    /**
     * 配送时间
     */
    public static Pattern DELIVERY_TIME = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}~\\d{2}:\\d{2}$");

}
