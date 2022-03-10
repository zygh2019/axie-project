package com.ddd.handle;

import com.ddd.model.gci.Threshold;
import lombok.Getter;
import lombok.Setter;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
public abstract class AbstractThresholdHandle {
    @Getter
    @Setter
    private Threshold threshold;
}
