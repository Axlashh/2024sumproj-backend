package edu.njust.back_end.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.njust.back_end.modules.sys.entity.DictionaryEntity;

import java.util.List;

public interface DictionaryDao extends BaseMapper<DictionaryEntity> {
    public List<DictionaryEntity> queryAll(DictionaryEntity dictionaryEntity);
}
