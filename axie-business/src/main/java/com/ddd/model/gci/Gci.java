package com.ddd.model.gci;

import com.ddd.share.Aggregate;
import com.ddd.share.Entity;

/**
 *
 * 打卡活动聚合
 * @author liushengbin
 * @date 2022/3/9
 */
public class Gci implements Entity<Gci> {

    //店铺id
    Long gciId;

    /**
     * Aggregate compare by identity, not by attributes.
     *
     * @param other The other Aggregate.
     * @return true if the identities are the same, regardless of other attributes.
     */
    @Override
    public boolean sameIdentityAs(Gci other) {
        return false;
    }
}
