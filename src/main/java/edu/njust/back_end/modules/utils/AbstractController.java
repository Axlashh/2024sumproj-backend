package edu.njust.back_end.modules.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.njust.back_end.modules.users.dao.SysUserDao;
import edu.njust.back_end.modules.users.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static edu.njust.back_end.config.ShiroConfig.getUserName;

public abstract class AbstractController {
    @Autowired
    SysUserDao sysUserDao;
    protected SysUserEntity getUser() {
        return sysUserDao.selectOne(new QueryWrapper<SysUserEntity>().eq("user_name", getUserName()));
    }
}
