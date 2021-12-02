package common.cons;

/**
 * @Description 返回结果码
 * @Param
 * @Return
 * @Date 2019/3/9 下午4:56 lsquan
 */
public class ResultCodeConst {
    //成功-1000
    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "success";

    //失败-9000
    public static final int FAIL_CODE = 9999;
    public static final String FAIL_MSG = "fail";

    // token验证失败-9002
    public static final int TOKEN_ERROR_CODE = 9002;
    public static final String TOKEN_ERROR_DEFAULT_MSG = "token验证失败";

    public static final int USER_HEAD_CODE = 9003;
    public static final String USER_HEAD_ERROR_MSG = "用户协议头校验失败";

    // 账号所属平台验证失败-9004
    public static final int PLATFORM_ERROR_CODE = 9004;
    public static final String PLATFORM_ERROR_CODE_MSG = "账号所属平台验证失败";

    // 请求参数错误-2001
    public static final int PARAM_ERROR = 2001;
    public static final String PARAM_ERROR_MSG = "请求参数错误";

    // 数据异常或不存在-2002
    public static final int DATA_ERROR = 2002;
    public static final String DATA_ERROR_MSG = "数据异常或不存在";

    // sql异常-2003
    public static final int SQL_ERROR = 2003;
    public static final String SQL_ERROR_MSG = "sql异常！";

    // 服务调用失败-2004
    public static final int FEIGN_SERVER_ERROR = 2004;
    public static final String FEIGN_SERVER_ERROR_MSG = "服务调用失败";

    // 请求参数不能不空-2002
    public static final int PARAM_NULL = 2005;
    public static final String PARAM_NULL_MSG = "请求参数不能不空";
    // 用户操作过于频繁-2009
    public static final int OPERATE_FREQUENT = 2009;
    public static final String OPERATE_FREQUENT_MSG = "您的操作太快啦,等一会再试哈!";

    // 系统错误,请联系客服-2006
    public static final int SYSTEM_ERROR = 2006;
    public static final String SYSTEM_ERROR_MSG = "Sorry,好像出了点问题!请稍后重试或联系客服";

    // 接口调用失败-2010
    public static final int OUTER_FAIL = 2011;
    public static final String OUTER_FAIL_MSG = "外部接口调用失败!";

    // 当前用户还未登陆状态-2010
    public static final int USR_NOT_LOGIN = 2012;
    public static final String USR_NOT_LOGIN_MSG = "当前用户还未登陆状态!";

    // 违法操作-2010
    public static final int LAW_ERROR = 2013;
    public static final String LAW_ERROR_MSG = "警告!违法操作!已经侵权!";

    // 无操作权限-2014
    public static final int PERMISSION_IS_NOT_EXIST = 2014;
    public static final String PERMISSION_IS_NOT_EXIST_MSG = "没有操作权限";

    // 用户被禁用-2015
    public static final int CUST_HAS_FORBIDDEN = 2015;
    public static final String CUST_HAS_FORBIDDEN_MSG = "用户被禁用!";

    /**
     * @Description 用户模块
     * @Date 2019/3/11 下午5:30 lsquan
     */
    public static class USER {
        /**
         * @Description 用户不存在-3001
         */
        public static final int USER_NOT_EXIST = 3001;
        public static final String USER_NOT_EXIST_MSG = "用户不存在！";
        /**
         * @Description 密码不正确-3002
         */
        public static final int USER_OR_PWD_ERROR = 3002;
        public static final String USER_OR_PWD_ERROR_MSG = "密码不正确";

        /**
         * @Description 当前帐号状态不可用，请联系管理员-3003
         */
        public static final int USER_STATUS_ERROR = 3003;
        public static final String USER_STATUS_ERROR_MSG = "当前帐号状态不可用，请联系管理员";

        /**
         * @Description 帐号平台不正确-3004
         */
        public static final int USER_PLATFORM_ERROR = 3004;
        public static final String USER_PLATFORM_ERROR_MSG = "帐号平台不正确";

        /**
         * @Description 该用户名已注册-3005
         */
        public static final int USERNAME_BE_REGISTER = 3005;
        public static final String USERNAME_BE_REGISTER_MSG = "该用户名已注册！";

        /**
         * @Description 该手机号码已注册-3005
         */
        public static final int PHONE_BE_REGISTER = 3006;
        public static final String PHONE_BE_REGISTER_MGS = "该手机号码已注册！";

        /**
         * @Description 角色名不能重复-3007
         */
        public static final int ROLE_BE_EXIST = 3007;
        public static final String ROLE_BE_EXIST_MSG = "角色名不能重复！";

        /**
         * @Description 角色名不能重复-3008
         */
        public static final int ROLE_EXIST_USER = 3008;
        public static final String ROLE_EXIST_USER_MSG = "该角色下存在用户！";

        /**
         * @Description 无该权限-3009
         */
        public static final int NO_AUTH = 3009;
        public static final String NO_AUTH_MSG = "无该权限！";


    }

    public static class VERIFICATION {
        /**
         * @Description 验证码已过期-5001
         */
        public static final int VERIFICATION_TIME_INVALID = 5001;
        public static final String VERIFICATION_TIME_INVALID_MSG = "验证码已过期";
        /**
         * @Description 验证码不正确-5002
         */
        public static final int VERIFICATION_FAIL = 5002;
        public static final String VERIFICATION_FAIL_MSG = "验证码不正确!";
        /**
         * @Description 验证码请勿重复请求-5004(短时间内联系发送验证码）
         */
        public static final int VERIFICATION_REPEAT_REQUEST = 5003;
        public static final String VERIFICATION_REPEAT_REQUEST_MSG = "您的操作过快,请稍后重试!";

    }

    public static class FILE {
        /**
         * @Description 文件不能为空-6000
         */
        public static final int FILE_IS_EMPTY = 6000;
        public static final String FILE_IS_EMPTY_MSG = "文件不能为空";

        /**
         * @Description 文件过大-6001
         */
        public static final int FILE_TOO_BIG = 6001;
        public static final String FILE_TOO_BIG_MSG = "文件大小超过限制";

        /**
         * @Description 上传文件格式不正确-6002
         */
        public static final int FILE_SUFFIX_ERROR = 6002;
        public static final String FILE_SUFFIX_ERROR_MSG = "上传文件格式不正确!";

        /**
         * @Description 文件内容不能为空-6002
         */
        public static final int FILE_CONTENT_NULL = 6003;
        public static final String FILE_CONTENT_NULL_MSG = "文件内容不能为空";

        /**
         * @Description 文件上传服务异常-6005
         */
        public static final int FILE_UPLOAD_ERROR = 6005;
        public static final String FILE_UPLOAD_ERROR_MSG = "文件上传异常";

    }

    /**
     * @Description 验证码
     */
    public static class VALID_CODE {

        public static final int VALID_CODE_ERROR = 7000;
        public static final String VALID_CODE_ERROR_MSG = "验证码不正确！";

        public static final int VALID_EXPIRE = 7001;
        public static final String VALID_EXPIRE_MSG = "验证码已失效，请刷新重试！";

        public static final int VALID_CODE_NOTNULL = 7002;
        public static final String VALID_CODE_NOTNULL_MSG = "请输入验证码!";
    }


    public static class WX {
        /**
         * 请求时间不能为空
         */
        public static final int GET_PHONE_FAIL = 11001;
        public static final String GET_PHONE_FAIL_MSG = "获取手机号码失败";

        /**
         * 获取sessionKey失败
         */
        public static final int GET_SESSIONKEY_FAIL = 11002;
        public static final String GET_SESSIONKEY_FAIL_MSG = "获取sessionKey失败";

        /**
         * 获取微信信息失败
         */
        public static final int GET_WX_INFO_FAIL = 11003;
        public static final String GET_WX_INFO_FAIL_MSG = "获取微信信息失败";


        /**
         * 请先获取手机号码
         */
        public static final int DONT_HAVE_PHONE = 11004;
        public static final String DONT_HAVE_PHONE_MSG = "请先获取手机号码";
        /**
         * 扫码
         */
        public static final int QR_CODE_IMG_ERROR = 11005;
        public static final String QR_CODE_IMG_ERROR_MSG = "二维码数据不正确";


    }

    public static class MOMENTS {

        /**
         * @Description 已被删除
         */
        public static final int BE_DELETE = 39004;
        public static final String BE_DELETE_MSG = "该内容已被删除！";

    }

    /**
     * 党员会议
     *
     * @author Noctis
     * @date 2021/06/08
     */
    public static class PARTY_MEETING {

        /**
         * @Description 您无权限查看会议内容
         */
        public static final int NO_PERMISSION = 40001;
        public static final String NO_PERMISSION_MSG = "您无权限查看会议内容";

    }

    /**
     * 银杏币红包
     *
     * @author lsquan
     * @date 2021/06/08
     */
    public static class COIN {

        /**
         * @Description 银杏币账户余额不足
         */
        public static final int ACCOUNT_NOT_ENOUGH = 40100;
        public static final String ACCOUNT_NOT_ENOUGH_MSG = "银杏币账户余额不足";
    }

    /**
     * 银杏币红包
     *
     * @author lsquan
     * @date 2021/06/08
     */
    public static class COIN_RED {

        /**
         * @Description 该红包已经超过24小时
         */
        public static final int RED_EXPIRE = 50000;
        public static final String RED_EXPIRE_MSG = "该红包已经超过24小时";

        /**
         * @Description 红包已经抢完了
         */
        public static final int RED_EMPTY = 50001;
        public static final String RED_EMPTY_MSG = "红包已经抢完了";

        /**
         * @Description 您已经抢过该红包了
         */
        public static final int GRABED_SUCCESS_ = 50002;
        public static final String GRABED_SUCCESS_MSG = "您已经抢过该红包了";

        /**
         * @Description 您已经抢过该红包了
         */
        public static final int NOT_THIS_VILLAGER = 50003;
        public static final String NOT_THIS_VILLAGER_MSG = "不是本村村民";

    }

}
