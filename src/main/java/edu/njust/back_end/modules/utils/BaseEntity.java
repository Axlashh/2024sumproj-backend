package edu.njust.back_end.modules.utils;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    public Date createTime; // 创建时间
    public Date updateTime; // 更新时间
}
