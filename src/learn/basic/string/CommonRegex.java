package learn.basic.string;

public class CommonRegex {
	public static void main(String[] args) {
		String str = "255.0.0.13";
		String s = StringUtil.getStrByReg(str, IP_V4);
		System.out.println(s);
	}

	// 正则中需要转义的特殊字符
	/*
	  $ . ? + $ ^ [ ] ( ) { } | \ /
	  在[]内特殊字符，表示匹配特殊字符本身，不需要加反斜杠
	 */
	/** 邮箱 */
	public static final String EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
	/**QQ号码*/
	public static final String QQ = "^[1-9]\\d{4,10}$";
	/**一个或多个汉字*/
	public static final String CHINESE = "^[\u4e00-\u9fa5]+$";
	/**电话*/
	public static final String PHONE = "^1[3|4|5|7|8]\\d{9}$";
	/**邮政编码*/
	public static final String POSTCODE = "^[1-9]\\d{5}$";
	/**URL*/
	public static final String URL = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
	/**身份证号码*/
	public static final String ID = "^(([1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3})|((\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)))$";
	public static final String ID15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$";
	public static final String ID18 = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)$";
	/**帐号，字母开头，允许5-16字节，允许字母数字下划线*/
	public static final String ACCOUNTS = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
	/**密码，以字母开头，长度在6~18之间，只能包含字母、数字和下划线*/
	public static final String PASSWD = "^[a-zA-Z]\\w{5,17}$";
	/**强密码，必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间*/
	public static final String STRENG_PASSWD="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$";
	/**日期,考虑了平闰年*/
	public static final String DATE = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
	/**时间*/
	public static final String TIME  = "^(0|1|2)[0-9]:[0-5]\\d:[0-5]\\d$";
	/**金额,精确到2位小数*/
	public static final String MONEY = "^[0-9]+(.[0-9]{2})?$";
	/**ie版本*/
	public static final String IE_VERSION = "^.*MSIE [5-8](?:\\.[0-9]+)?(?!.*Trident\\/[5-9]\\.0).*$";
	/**IPv4*/
	public static final String IP_V4 = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b"; 
	/**IPv6*/
	public static final String IP_V6 = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))"; 
	/**文件路径及后缀*/
	public static final String PATH_SUFFIX = "^([a-zA-Z]\\:|\\\\)\\\\([^\\\\]+\\\\)*[^\\/:*?<>|]+\\.txt(l)?$";
	/**颜色*/
	public static final String COLOR = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
	/**网页图片*/
	public static final String WEB_IMG = "\\< *[img][^\\\\>]*[src] *= *[\\']{0,1}([^\\'\\ >]*)";
}
