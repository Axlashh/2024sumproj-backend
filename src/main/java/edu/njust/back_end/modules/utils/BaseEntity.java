package edu.njust.back_end.modules.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEntity extends BaseQuery {
    public Date createTime; // 创建时间
    public Date updateTime; // 更新时间
}
