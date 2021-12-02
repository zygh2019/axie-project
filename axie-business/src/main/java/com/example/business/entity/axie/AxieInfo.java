package com.example.business.entity.axie;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AxieInfo extends Model<AxieInfo> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签
     */
    private String label;

    /**
     * pvp分数
     */
    private Integer mmr;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
