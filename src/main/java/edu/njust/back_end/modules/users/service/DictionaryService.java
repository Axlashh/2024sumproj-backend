package edu.njust.back_end.modules.users.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.njust.back_end.modules.users.entity.DictionaryEntity;

import java.util.List;

public interface DictionaryService extends IService<DictionaryEntity> {
    List<DictionaryEntity> getAllDictionaries();

}
