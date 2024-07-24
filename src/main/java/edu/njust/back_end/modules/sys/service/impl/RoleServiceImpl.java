package edu.njust.back_end.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.sys.dao.MenuDao;
import edu.njust.back_end.modules.sys.dao.RoleDao;
import edu.njust.back_end.modules.sys.entity.MenuEntity;
import edu.njust.back_end.modules.sys.entity.RoleEntity;
import edu.njust.back_end.modules.sys.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {
}
