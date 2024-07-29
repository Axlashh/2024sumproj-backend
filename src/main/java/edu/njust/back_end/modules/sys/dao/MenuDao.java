package edu.njust.back_end.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.njust.back_end.modules.sys.entity.DictionaryEntity;
import edu.njust.back_end.modules.sys.entity.MenuEntity;

import java.util.List;

public interface MenuDao extends BaseMapper<MenuEntity> {
    List<MenuEntity> queryListByParentIdAndUserId(String parentId, String userId);

    public List<MenuEntity> queryAll(MenuEntity menuEntity);
}
