package edu.njust.back_end.modules.users.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.users.entity.DictionaryEntity;
import edu.njust.back_end.modules.users.mapper.DictionaryMapper;
import edu.njust.back_end.modules.users.service.DictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, DictionaryEntity> implements DictionaryService {
    @Autowired
private DictionaryMapper dictionaryMapper;

    public List<DictionaryEntity> getAllDictionaries() {
        return dictionaryMapper.selectList(null); // 查询所有数据
    }
}
