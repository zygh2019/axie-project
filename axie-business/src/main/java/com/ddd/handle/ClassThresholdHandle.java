package com.ddd.handle;

import com.ddd.enums.ThreasHoldTypeEnum;
import com.ddd.model.gci.ClassThreshold;
import com.ddd.model.gci.Threshold;

import javax.annotation.Resource;

/**
 * 门槛校验处理器
 *
 * @author liushengbin
 * @date 2022/3/10
 */
public class ClassThresholdHandle extends AbstractThresholdHandle implements ThresholdHandle {
    @Resource
    Object classRepository;

    @Override
    public boolean check(Threshold threshold) {
        ClassThreshold classParmBuild = new ClassThreshold(threshold.getClassId(),classRepository);
        //校验参数
        classParmBuild.checkParm();
        //校验业务
        classParmBuild.checkBiz();

        return false;
    }


    @Override
    public ThreasHoldTypeEnum getType() {
        return ThreasHoldTypeEnum.CLASS;
    }

}
