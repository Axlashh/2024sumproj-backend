package edu.njust.back_end.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.sys.dao.MenuDao;
import edu.njust.back_end.modules.sys.dao.RoleMenuDao;
import edu.njust.back_end.modules.sys.dao.RoleUserDao;
import edu.njust.back_end.modules.sys.entity.MenuEntity;
import edu.njust.back_end.modules.sys.entity.RoleUserEntity;
import edu.njust.back_end.modules.sys.service.MenuService;
import edu.njust.back_end.modules.users.entity.SysUserEntity;
import edu.njust.back_end.modules.users.service.SysUserService;
import edu.njust.back_end.modules.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RoleMenuDao roleMenuDao;

    @Autowired
    RoleUserDao roleUserDao;

    @Override
    public List<MenuEntity> getMenuListByUserId(String userId) {
        return getAllMenuList(userId);
    }

    /**
     * 获取角色对应的菜单
     * @param RoleId
     * @return
     */
    public List<MenuEntity> getMenuListByRoleId(String RoleId) {
        return null;
    }

    /**
     *
     * @param userId
     * @return
     */
    private List<MenuEntity> getAllMenuList(String userId) {
        // 查询根菜单列表
        List<MenuEntity> menuList = baseMapper.queryListByParentIdAndUserId(0L + "", userId);
        // 递归获取子菜单
        getMenuTreeList(menuList, userId);

        return menuList;
    }

    private List<MenuEntity> getMenuTreeList(List<MenuEntity> menuList, String userId) {
        List<MenuEntity> subMenuList = new ArrayList<MenuEntity>();

        for (MenuEntity entity : menuList) {
            // 目录
            if (entity.getType() == Constant.MenuType.CATALOG.getValue()) {
                entity.setChildren(getMenuTreeList(baseMapper.queryListByParentIdAndUserId(entity.getMenuId(), userId), userId));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
