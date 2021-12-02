package common.utils.response;

import common.cons.ResultCodeConst;
import lombok.Data;

/**
 * @Description 成功类
 * @Param
 * @Return
 * @Date 2019/3/7 上午10:59 lsquan
 */
@Data
public class Success extends ApiResponse {
    public Success() {
        super(ResultCodeConst.SUCCESS_CODE);
    }

    public Success(String msg, Object data) {
        super(ResultCodeConst.SUCCESS_CODE);
        super.msg = msg;
        super.count = 100;
        super.data = data;
    }
}
