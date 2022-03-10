package com.ddd.factory;

import com.ddd.delegate.ThresholdHandleDelegate;
import com.ddd.delegate.ThresholdHandleDelegateImpl;
import com.ddd.handle.ThresholdHandle;
import com.ddd.model.gci.ClassThreshold;
import com.ddd.model.gci.Gci;
import com.ddd.model.gci.GciActivite;
import com.ddd.model.gci.Threshold;
import com.ddd.share.Aggregate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;
import java.util.List;

/**
 * 打卡活动聚合
 *
 * @author liushengbin
 * @date 2022/3/9
 */
public class GciActiviteFactory {
    @Resource
    private List<ThresholdHandle> thresholdHandleList;

    void createNewGci() {
        //  规则委派对象
        ThresholdHandleDelegate thresholdHandleDelegate = new ThresholdHandleDelegateImpl(thresholdHandleList);
        //门槛
        Threshold threshold = new Threshold();
        GciActivite build = GciActivite.builder()
                .thresholdHandleDelegate(thresholdHandleDelegate)
                .threshold(threshold).build();
        //门槛校验
        build.check();

    }
}
