package com.ddd.model.gci;

import com.ddd.enums.ThreasHoldTypeEnum;
import com.ddd.share.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 门槛
 *
 * @author liushengbin
 * @date 2022/3/9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassThreshold extends Threshold {
    /**
     * 班级id
     */
    private Long classId;

    /**
     * 仓储
     */
    private Object classRepository;

    /**
     * 校验参数
     *
     * @return
     */
    public boolean checkParm() {


        return Objects.isNull(classId);
    }

    /**
     * 校验业务
     *
     * @return
     */
    public boolean checkBiz() {

        //classRepository.
        return Objects.isNull(classId);
    }
}
