package com.ddd.delegate;

import com.ddd.handle.ThresholdHandle;
import com.ddd.model.gci.Threshold;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
@AllArgsConstructor
public class ThresholdHandleDelegateImpl implements ThresholdHandleDelegate{

    private List<ThresholdHandle> thresholdHandleList;

    @Override
    public boolean check(Threshold threshold) {

        //  获取路由实现 ，根据规则类型去执行对应的逻辑
        ThresholdHandle thresholdHandle = thresholdHandleList
                .stream()
                .filter(handler -> handler.getType().equals(threshold.getThreasHoldTypeEnum().getCode()))
                .findFirst()
                .orElse(null);
        thresholdHandle.check();
        return false;
    }
}
