package com.ddd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;

/**
 * @author liushengb9in
 * @date 2021-12-25
 */
@Getter
@AllArgsConstructor
public enum ThreasHoldTypeEnum implements Serializable {

    COLUM(1, "专栏"),
    CLASS(2, "班课");

    private Integer code;
    private String desc;
    private String desc2;

    ThreasHoldTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String desc() {
        return ObjectUtils.defaultIfNull(desc2, desc);
    }

    public static ThreasHoldTypeEnum getByCode(int code) {
        for (ThreasHoldTypeEnum value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
