package common.utils.response;

import common.cons.ResultCodeConst;

/**
 * @Description 接口返回工具类
 * @Param
 * @Return
 * @Date 2019/3/7 上午10:53 lsquan
 */
public class ResponseUtil {

    /**
     * @Description 成功
     * @Param [data]
     * @Date 2019/3/7 上午10:54 lsquan
     */
    public static ApiResponse success(Object data) {
        return success(ResultCodeConst.SUCCESS_MSG, data);
    }

    /**
     * @Description 成功，自定义msg
     * @Param [msg, data]
     * @Return com.cloud.rsd.healthPro.common.base.response.ApiResponse
     * @Date 2019/3/7 上午10:54 lsquan
     */
    public static ApiResponse success(String msg, Object data) {
        return new Success(msg, data);
    }



}
