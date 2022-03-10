package com.ddd.model.gci;

import com.ddd.delegate.ThresholdHandleDelegate;
import com.ddd.share.Aggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 打卡活动聚合
 *
 * @author liushengbin
 * @date 2022/3/9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GciActivite implements Aggregate<GciActivite> {

    //店铺id
    Long kdtId;
    /**
     * 打卡实体
     */
    Gci gci;
    /**
     * 门槛
     */
    Threshold threshold;

    /**
     * 信息采集
     */
    Object information;

    ThresholdHandleDelegate thresholdHandleDelegate;
    /**
     * 检查是否满足门槛
     *
     * @return
     */
    public boolean check() {
        //专栏需要查询
        //根据类型做路由 然后做校验
        //如果为班课
       //交给处理器
      //  AbstractThresholdHandle thresholdCheckHandle = new AbstractThresholdHandle(threshold);
        thresholdHandleDelegate.check(threshold);
        return true;
    }

    /**
     * Aggregate compare by identity, not by attributes.
     *
     * @param other The other Aggregate.
     * @return true if the identities are the same, regardless of other attributes.
     */
    @Override
    public boolean sameIdentityAs(GciActivite other) {
        return false;
    }
}
