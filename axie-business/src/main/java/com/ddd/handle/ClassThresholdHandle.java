package com.ddd.handle;

import com.ddd.enums.ThreasHoldTypeEnum;
import com.ddd.model.gci.ClassThreshold;
import com.ddd.model.gci.Threshold;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
public class ClassThresholdHandle extends AbstractThresholdHandle implements ThresholdHandle {


    @Override
    public boolean check() {
        Threshold threshold = super.getThreshold();
        if(threshold instanceof ClassThreshold){
            ClassThreshold classThreshold = (ClassThreshold) threshold;
            classThreshold.getClassId();
            //去校验门槛
        }


        return false;
    }

    @Override
    public ThreasHoldTypeEnum getType() {
        return ThreasHoldTypeEnum.CLASS;
    }
}
