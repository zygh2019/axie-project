package com.ddd.model.gci;

import com.ddd.enums.ThreasHoldTypeEnum;
import com.ddd.share.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liushengbin
 * @date 2022/3/9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public  class Threshold implements ValueObject<Threshold> {

  private  ThreasHoldTypeEnum threasHoldTypeEnum;
    /**
     * 班课门槛
     */
    private  ClassThreshold classThreshold;
    /**
     * 支付门槛
     */
    private  Object payThreshold;
    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(Threshold other) {
        return false;
    }

}
