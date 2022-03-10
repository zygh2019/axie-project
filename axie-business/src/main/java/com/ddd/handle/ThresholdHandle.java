package com.ddd.handle;

import com.ddd.enums.ThreasHoldTypeEnum;
import com.ddd.model.gci.Threshold;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
public interface ThresholdHandle {


     boolean check(Threshold threshold);

    ThreasHoldTypeEnum getType();

}
