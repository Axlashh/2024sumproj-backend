package edu.njust.back_end.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.njust.back_end.modules.sys.entity.DictionaryEntity;

import java.util.List;

public interface DictionaryService extends IService<DictionaryEntity> {
    public List<DictionaryEntity> queryAll(DictionaryEntity dictionaryEntity);

}
