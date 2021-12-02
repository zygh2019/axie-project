package common.utils;

import lombok.Builder;
import lombok.Data;

/**
 * layui统一返回
 * @param <A>
 */
@Data
@Builder
public class LayuiRescult<T> {

    /**
     * 代码
     */
    String code;
    /**
     * 用户
     */
    String message;
    /**
     * 数量
     */
    Long count;


    T data;
}
