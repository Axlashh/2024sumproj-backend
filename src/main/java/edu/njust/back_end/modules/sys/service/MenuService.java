package edu.njust.back_end.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.njust.back_end.modules.sys.entity.MenuEntity;

import java.util.List;

public interface MenuService extends IService<MenuEntity> {
    public List<MenuEntity> getMenuListByUserId(String userId);

    public List<MenuEntity> getMenuListByRoleId(String RoleId);

}
