package edu.njust.back_end.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RoleEntity implements Serializable {

    private String roleId; // 角色id
    private String roleName; // 角色名
    private String remark; // 备注
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}
