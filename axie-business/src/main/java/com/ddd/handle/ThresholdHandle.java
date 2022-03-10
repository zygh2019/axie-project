package com.ddd.handle;

import com.ddd.enums.ThreasHoldTypeEnum;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
public interface ThresholdHandle {


     boolean check();

    ThreasHoldTypeEnum getType();
}
