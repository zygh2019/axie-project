package common.utils.response;

import lombok.Data;

/**
 * @Description 统一数据包装类
 * @Param
 * @Return
 * @Date 2019/3/18 下午3:51 lsquan
 */
@Data
public class ApiResponse<T> {
    /**
     * 代码
     */
    public int code;
    /**
     * 数据
     */
    public T data;
    /**
     * 消息
     */
    public String msg;
    public Integer count;

    public ApiResponse(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public ApiResponse() {
    }
}
