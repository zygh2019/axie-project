package com.ddd.delegate;

import com.ddd.enums.ThreasHoldTypeEnum;
import com.ddd.model.gci.Threshold;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
public interface ThresholdHandleDelegate {


    boolean check(Threshold  threshold);
}
