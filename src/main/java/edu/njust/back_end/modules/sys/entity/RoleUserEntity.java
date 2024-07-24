package edu.njust.back_end.modules.sys.entity;

// 表 18 角色用户表 role_user

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleUserEntity implements Serializable {

    private String id; // 唯一id
    private String roleId; // 角色id
    private String userId; // 用户id
}