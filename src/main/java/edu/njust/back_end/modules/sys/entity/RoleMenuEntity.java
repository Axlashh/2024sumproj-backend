package edu.njust.back_end.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("role_menu")
public class RoleMenuEntity implements Serializable {

    private String id; // 唯一id
    private String roleId; // 角色id
    private String menuId; // 菜单id
}