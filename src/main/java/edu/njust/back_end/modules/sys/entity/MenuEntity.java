package edu.njust.back_end.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MenuEntity extends BaseEntity implements Serializable {

    private String menuId; // 菜单id
    private String parentId; // 父菜单id，一级菜单为0
    private String name; // 菜单名
    private String url; // 菜单路径
    private String perms; // 授权(多个用逗号分隔，如：user:list,user:create)
    private int type; // 类型 (0:目录 1:页面 2:按钮)
    private String icon; // 菜单图标
    private int orderNum; // 排序值
    @TableField(exist = false)
    private List<MenuEntity> children;
}

