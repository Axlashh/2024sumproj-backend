package edu.njust.back_end.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.sys.dao.DictionaryDao;
import edu.njust.back_end.modules.sys.entity.DictionaryEntity;
import edu.njust.back_end.modules.sys.service.DictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, DictionaryEntity> implements DictionaryService {
    @Autowired
    DictionaryDao dictionaryDao;

    public List<DictionaryEntity> queryAll(DictionaryEntity dictionaryEntity) {
        return baseMapper.queryAll(dictionaryEntity);
    }
}
